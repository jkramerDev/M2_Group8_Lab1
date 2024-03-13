package template;

/**
 *   model a PhonebookEntry 
 *   
 *   PhonebookEntry has a phoneNumber and type
 *   
 *   
 *   
 */

class PhonebookEntry{
	private PhoneType phoneType;
	private PhoneNumber phoneNumber;
	
	public PhonebookEntry(PhoneType type, PhoneNumber number) {
		this.phoneType = type;
		this.phoneNumber = number;
	}
	
	
	/**
	 * Getter method for phoneType.
	 * @return The type of phone number.
	 */
	public PhoneType getType() {
		return this.phoneType;
	}
	
	/**
	 * Getter method for phoneNumber
	 * @return The phone number object.
	 */
	public PhoneNumber getNumber() {
		return this.phoneNumber;
	}
	
	//TODO setters

 
}
	