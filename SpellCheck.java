import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

//When the program's output is turned on, it reads the wordlist into a hash table, 
//then begins reading from the input text file one word at a time. Each word is looked up in the wordlist.
//If it is not found, the program writes the entire line of the input file that contained that word,
//along with an indication of which word was misspelled,
//and a sorted list of suggestions.

public class SpellCheck
{
	public static void main(String[] args) throws FileNotFoundException
	{
		String fileName = "wordlist.txt";
		File f = new File(fileName);
		Scanner s = new Scanner(f);
		StringHasher hasher = new BetterStringHasher();
		int size = s.nextInt();
		String line;
		
		ArrayList<String> misspell = new ArrayList<String>();
		ArrayList<String> sugg = new ArrayList<String>();
		
		
		
		HashTable wordlist = new HashTable(size, hasher);
	
		while(s.hasNext())
		{
			line = s.next();
			wordlist.add(line);
			System.out.println("added "+line);
		}
	
		
		String command = "";
		System.out.print("Enter command: ");
		Scanner s2 = new Scanner(System.in);
		command = s2.nextLine();
		
		StringTokenizer st = new StringTokenizer(command);
		
		
		String wordToSearch="";
		
		
		while(st.hasMoreElements())
		{
			
			wordToSearch = st.nextToken();
			
			if(wordlist.lookup(wordToSearch))
			{
				return;
			}
			else
			{
				misspell.add(wordToSearch);
			}
				
		}
		
		for(int i = 0; i < misspell.size(); i++)
		{
			
			System.out.println("Misspelled words: "+misspell.get(i));
		}
		
		
	}

}
