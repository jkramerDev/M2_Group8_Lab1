package template;

import java.util.ArrayList;
import java.util.Arrays;

public class PhoneNumber implements Comparable<PhoneNumber> {
	private int areaCode;
	private int prefix;
	private int lineNumber;
	
	public PhoneNumber(Long phoneNumber) {
		if(new Long(phoneNumber).compareTo(new Long("9999999999")) > 0) {
			throw new IllegalArgumentException("Phone number must be maximum of 10 digits.");
		} else {
			this.lineNumber = new Long(phoneNumber % 10000).intValue();
			this.prefix = new Long((phoneNumber / 10000) % 1000).intValue();
			this.areaCode = new Long((phoneNumber / 10000000)).intValue();
		}
	}
	
	public Long getLongPhoneNumber() {
		return new Long("" + this.areaCode + this.prefix + this.lineNumber);
	}
	
	@Override
	public String toString() {
		return "(" + String.format("%03d", this.areaCode) + ")" + String.format("%03d", this.prefix) + "-" + String.format("%04d", this.lineNumber);
	}
	
	@Override
	public int compareTo(PhoneNumber a) {
		return this.getLongPhoneNumber().compareTo(a.getLongPhoneNumber());
	}
	
	public static void main(String[] args) {
		Long num1 = new Long("7817840582");
		Long num2 = new Long("7817934028");
		PhoneNumber pn1 = new PhoneNumber(num1);
		PhoneNumber pn2 = new PhoneNumber(num2);
		PhoneNumber[] pnl = {new PhoneNumber(num2), new PhoneNumber(num1)};
		System.out.println(pn1.compareTo(pn2));
		Arrays.sort(pnl);
		System.out.println(Arrays.toString(pnl));
	}
	
	
}
