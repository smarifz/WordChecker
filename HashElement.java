public class HashElement {
	private String key;
	private int value;
	private HashElement next;

	HashElement(String key, int value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public HashElement getNext() {
		return next;
	}

	public void setNext(HashElement next) {
		this.next = next;
	}
}