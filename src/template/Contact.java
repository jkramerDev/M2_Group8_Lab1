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
	
	// TODO addition of entries, hashcode, and equals
}
