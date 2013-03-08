// StringHasher.java
//
// ICS 23 / CSE 23 Summer 2012
// Project #5: Lost for Words
//
// A common interface used by all hash functions for strings.  This allows
// the HashTable class to be built to use any hash function.


public interface StringHasher
{
	// hash() returns an integer that is a hash value for the given string s.
	// The integer can potentially be any value in the range of Java ints
	// (i.e. Integer.MIN_VALUE .. Integer.MAX_VALUE).
	public int hash(String s);
}
