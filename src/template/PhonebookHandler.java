package template;

import java.util.*;

/**
 * PhonebookHandler - supports 
 * Phonebook operations
 * 
 * Use a map to build the Phonebook
 * key: Contact
 * value: List<phonebookEntries>
 */

public class PhonebookHandler implements iPhonebookHander{
	private Map<Contact, List<PhonebookEntry>> phonebookHashMap = new HashMap();
	
	public PhonebookHandler(Map<Contact, List<PhonebookEntry>> map) {
		this.phonebookHashMap = map;
	}


	@Override
	public List<Contact> sortByName() {
		List<Contact> unsortedList = new ArrayList<>();
		List<Contact> sortedList = new ArrayList<>();
		
		unsortedList.addAll(this.phonebookHashMap.keySet());
		
		while(unsortedList.size() > 0) {
			Contact lowestContact = unsortedList.get(0);
			for(Contact e : unsortedList) {
				if(e.getName().compareTo(lowestContact.getName()) < 0) {
					lowestContact = e;
				}
			}
			
			sortedList.add(lowestContact);
			unsortedList.remove(lowestContact);
		}
		return sortedList;
		
		// lazy bubble sort
	}

	@Override
	public List<PhonebookEntry> binarySearch(List<Contact> sortedContacts, String name) {
		int upperFence = sortedContacts.size() - 1;
		int lowerFence = 0;
		int mid = 0;
		
		while(upperFence - lowerFence > 0) {
			mid = lowerFence + ((upperFence - lowerFence) / 2);
			if(sortedContacts.get(mid).getName().strip().compareTo(name) > 0) {
				upperFence = mid;
			} else {
				lowerFence = mid;
			}
		}
		
		if(sortedContacts.get(lowerFence).getName().strip().equalsIgnoreCase(name)) {
			return sortedContacts.get(lowerFence).getPhonebookEntries();
		} else if(sortedContacts.get(upperFence).getName().strip().equalsIgnoreCase(name)) {
			return sortedContacts.get(upperFence).getPhonebookEntries();
		} else if(sortedContacts.get(mid).getName().strip().equalsIgnoreCase(name)) {
			return sortedContacts.get(mid).getPhonebookEntries();
		}
		return null;
		
		// bin search does not work, i'm pretty sure this is because i separated name into first/last and the given implementation of just one name.
	}

	@Override
	public void display(List<Contact> sortedContacts) {
		for (Contact c : sortedContacts) {
			System.out.print(c.getName());
			System.out.print("\t");
			System.out.println(c.getPhonebookEntries());
		}
		
	}
	
	//TODO yeah all of it
 
}
