package template;

/**
 *   model a PhonebookEntry 
 *   
 *   PhonebookEntry has a phoneNumber and type
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
	public PhoneNumber getPhoneNumber() {
		return this.phoneNumber;
	}
	
	/**
	 * Updates the phoneType field.
	 * @param newType The PhoneType to update the phoneType field to.
	 * @return Success if true.
	 */
	public boolean setType(PhoneType newType) {
		this.phoneType = newType;
		
		return this.phoneType == newType;
	}
	
	/**
	 * Update the phoneNumber field.
	 * @param newNumber The PhoneNumber to update the phoneNumber field to.
	 * @return Success if true.
	 */
	public boolean setNumber(PhoneNumber newNumber) {
		this.phoneNumber = newNumber;
		
		return this.phoneNumber.getLongPhoneNumber() == newNumber.getLongPhoneNumber();
	}
	
	@Override
	public String toString() {
		String output = "";
		if(this.phoneType == PhoneType.HOME) {
			output += "[Home] ";
		} else if (this.phoneType == PhoneType.MOBILE) {
			output += "[Cell] ";
		} else if (this.phoneType == PhoneType.WORK) {
			output += "[Work] ";
		} else {
			output += "[Other]";
		}
		output += this.phoneNumber.toString();
		return output;
	}
}
	