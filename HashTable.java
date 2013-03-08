import java.util.ArrayList;

// HashTable.java
//
// ICS 23 / CSE 23 Summer 2012
// Project #5: Lost for Words
//
// Implement your hash table here.  You are required to use the separate
// chaining strategy that we discussed in lecture, meaning that collisions
// are resolved by having each cell in the table be a linked list of all of
// the strings that hashed to that cell.


public class HashTable
{
	ArrayList<HashList> words;

	StringHasher hasher;

	int tableSize;

	// The constructor is given a table size (i.e. how big to make the array)
	// and a StringHasher, which is used to hash the strings.
	public HashTable(int tableSize, StringHasher hasher)
	{

		this.tableSize = tableSize;

		words = new ArrayList<HashList>(tableSize);

		hasher = new BetterStringHasher();

		this.hasher = hasher;

		HashList temp = new HashList();


		int i =0;

		System.out.println("Table Size ="+tableSize);


		while(i<=tableSize)
		{
			words.add(temp);
			i++;
			System.out.println("Object made in element "+i);
		}

	}


	// add() takes a string and adds it to the hash table, if it's not already
	// in the hash table.  If it is, this method has no effect.
	public void add(String s)
	{

		int hashedValue = hasher.hash(s);
		if(hashedValue < 0)
			hashedValue *= -1;
		
		HashElement newElement = new HashElement(s, hashedValue);

		//System.out.println("hashed value = "+hashedValue);

		while(hashedValue > tableSize)
		{
			int prev;
			
			if(hashedValue > 0)
			{
				hashedValue = hashedValue % 50;
				prev = hashedValue;

				//System.out.println("new hashed value ="+hashedValue);
				
				if(prev < hashedValue)
					hashedValue = prev;
			}
			else if(hashedValue == 0)
				hashedValue = 0;
		}

		
		words.get(hashedValue).list.addToFront(newElement);
		System.out.println("Added word into list "+newElement.getKey());


	}


	// lookup() takes a string and returns true if that string appears in the
	// hash table, false otherwise.
	public boolean lookup(String s)
	{
		int hashedValue = hasher.hash(s);
		if(hashedValue < 0)
			hashedValue *= -1;
		
		while(hashedValue > tableSize)
		{
			int prev;
			
			if(hashedValue > 0)
			{
				hashedValue = hashedValue % 50;
				prev = hashedValue;

				if(prev < hashedValue)
					hashedValue = prev;
			}
			else if(hashedValue == 0)
				hashedValue = 0;
		}
		
		
		HashElement curr = words.get(hashedValue).getList().readFront();

		LinkedList<HashElement>.Iterator i = words.get(hashedValue).getList().iterator();
		
		while(i.hasNext())
		{

			if(!(curr.getKey().equals(s)))
			{
				curr = i.next();
			}
			else
				return true;
			
		}

		return false;


	}


	// remove() takes a string and removes it from the hash table, if it
	// appears in the hash table.  If it doesn't, this method has no effect.
	public void remove(String s)
	{

		int hashedValue = hasher.hash(s);
		if(hashedValue < 0)
			hashedValue *= -1;
		
		HashElement newElement = new HashElement(s, hashedValue);
		
		System.out.println("hashed value = "+hashedValue);

		while(hashedValue > tableSize)
		{
			int prev;
			
			if(hashedValue > 0)
			{
				hashedValue = hashedValue % 50;
				prev = hashedValue;

				System.out.println("new hashed value ="+hashedValue);
				
				if(prev < hashedValue)
					hashedValue = prev;
			}
			else if(hashedValue == 0)
				hashedValue = 0;
		}
		
		words.get(hashedValue).getList().remove(newElement);
		
	}
	
}
