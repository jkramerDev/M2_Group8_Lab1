package template;

import java.util.ArrayList;


/**
 * model a Contact
 * Contact has a name & list of phonebook entries
 * 
 * Support adding phonebookEntry to a contact
 * 
 * @Override hashCode and equals
 * 
 */

class Contact {
	private String firstName;
	private String lastName;
	private ArrayList<PhonebookEntry> phonebookEntries = new ArrayList();

	public Contact(String fName, String lName, PhonebookEntry... pbEntries) {
		this.firstName = fName;
		this.lastName = lName;
		for (PhonebookEntry pbEntry : pbEntries) {
			this.phonebookEntries.add(pbEntry);
		}
	}
	
	public Contact(String name) {
		this(name, "");
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	public ArrayList<PhonebookEntry> getPhonebookEntries() {
		return this.phonebookEntries;
	}
	
	@Override
	public int hashCode() {
		int lnHash = this.lastName.hashCode();
		int fnHash = this.firstName.hashCode();
		int feHash = this.phonebookEntries.get(0).getPhoneNumber().getLongPhoneNumber().hashCode();
		
		return lnHash + fnHash + feHash;
	}
	
//	@Override
	// ?? it doesn't like my override here for some reason
	public boolean equals(Contact c) {
		return this.hashCode() == c.hashCode() && this.getPhonebookEntries().containsAll(c.phonebookEntries);
	}
	
	public boolean addPhonebookEntry(PhonebookEntry newEntry) {
		return this.phonebookEntries.add(newEntry);
	}
	
	public boolean addPhonebookEntry(String number, String type) {
		switch(type) {
		case "Home":
			return this.addPhonebookEntry(new PhonebookEntry(PhoneType.HOME, new PhoneNumber(Long.parseLong(number))));
		case "Work":
			return this.addPhonebookEntry(new PhonebookEntry(PhoneType.WORK, new PhoneNumber(Long.parseLong(number))));
		case "Cell":
			return this.addPhonebookEntry(new PhonebookEntry(PhoneType.MOBILE, new PhoneNumber(Long.parseLong(number))));
		}
		return false;
	}
}
