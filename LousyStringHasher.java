// LousyStringHasher.java
//
// ICS 23 / CSE 23 Summer 2012
// Project #5: Lost for Words
//
// A pretty lousy hash function for strings.  What's so lousy about it is
// that it simply adds up the codes for each character, meaning that any
// word with the same set of characters in it, regardless of the order of
// those characters, hashes to the same place (i.e. hash("alex") ==
// hash("xela")).  Furthermore, most strings of the same length will tend
// to hash to roughly the same place in the table.  Consider why this is
// such a poor strategy.


public class LousyStringHasher implements StringHasher
{
	public int hash(String s)
	{
		int h = 0;
		
		for (int i = 0; i < s.length(); ++i)
		{
			h += s.charAt(i);
		}
		
		return h;
	}
}
