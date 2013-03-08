// WordChecker.java
//
// ICS 23 / CSE 23 Summer 2012
// Project #5: Lost for Words
//
// Implement your word checker here.  A word checker has two responsibilities:
// given a word list, answer the questions "Is the word 'x' in the wordlist?"
// and "What are some suggestions for the misspelled word 'x'?"
//
// WordChecker uses a class called WordList that I haven't provided the source
// code for.  WordList has only one method that you'll ever need to call:
//
//     public boolean lookup(String word)
//
// which returns true if the given word is in the WordList and false if not.


import java.util.ArrayList;
import java.util.HashSet;



public class WordChecker
{
	WordList wordList;

	// Initializes a new WordChecker with a given WordList.
	public WordChecker(WordList wordList)
	{

		this.wordList = wordList;

	}


	// wordExists() returns true if the given word is in the WordList passed
	// to the constructor, false otherwise.
	public boolean wordExists(String word)
	{

		if(wordList.lookup(word))
			return true;
		else 
			return false;


	}


	//Swapping adjacent pairs
	public String sugg1(String word)
	{
		ArrayList<Character> chars = new ArrayList<Character>();

		String returnString = "";

		if(word.length() % 2 == 0)
		{

			for(int i = 0; i<word.length(); i++)
			{
				int j=i+1;

				char first = word.charAt(i);
				char second = word.charAt(j);


				chars.add(second);
				chars.add(first);

				i++;
			}

		}
		else
		{
			for(int i = 0; i<word.length()-1; i++)
			{
				int j=i+1;

				char first = word.charAt(i);
				char second = word.charAt(j);

				chars.add(second);
				chars.add(first);

				i++;
			}
		}


		for(int i = 0; i<chars.size(); i++)
		{
			returnString += chars.get(i);
		}

		return returnString;
	}


	//Adding a letter between each word
	public ArrayList<String> sugg2(String word)
	{
		ArrayList<Character> chars = new ArrayList<Character>();

		ArrayList<String> suggList = new ArrayList<String>();

		String temp ="";


		if(word.length() % 2 == 0)
		{

			for(int i=0; i<word.length(); i++)
			{
				chars.add(word.charAt(i));
			}

			for(int i=0; i<chars.size(); i++)
			{
				for( char j = 'a'; j <= 'z'; j++ )
				{
					chars.add(i, j);

					for(int a= 0; a < chars.size();a++)
					{
						temp += chars.get(a);
					}

					suggList.add(temp);

					chars.remove(i);
					temp ="";
				}

			}

			temp ="";

		}
		else
		{
			for(int i=0; i<word.length(); i++)
			{
				chars.add(word.charAt(i));
			}

			for(int i=0; i<chars.size()-1; i++)
			{
				for( char j = 'a'; j <= 'z'; j++ )
				{
					chars.add(i, j);

					for(int a= 0; a < chars.size();a++)
					{
						temp += chars.get(a);
					}

					suggList.add(temp);

					chars.remove(i);
					temp ="";
				}

			}

		}

		for( char j = 'a'; j <= 'z'; j++ )
		{
			chars.add(chars.size(), j);

			for(int a= 0; a < chars.size();a++)
			{
				temp += chars.get(a);
			}

			suggList.add(temp);
			chars.remove(chars.size()-1);
			temp ="";

		}

		return suggList;

	}


	//Deleting each letter from the word
	public ArrayList<String> sugg3(String word)
	{

		ArrayList<Character> chars = new ArrayList<Character>();
		String temp = "";

		ArrayList<String> suggDel = new ArrayList<String>();

		ArrayList<String> returnSugg = new ArrayList<String>();


		for(int i=0; i<word.length(); i++)
		{
			chars.add(word.charAt(i));
		}

		for(int i=0; i<chars.size(); i++)
		{
			chars.remove(i);

			for(int j=0; j<chars.size(); j++)
			{
				temp+=chars.get(j);
			}

			suggDel.add(temp);
			temp = "";
			chars.removeAll(chars);

			for(int a=0; a<word.length(); a++)
			{
				chars.add(word.charAt(a));
			}

		}

		for(int i=0; i<suggDel.size(); i++)
		{
			if(wordList.lookup(suggDel.get(i)))
			{
				returnSugg.add(suggDel.get(i));
			}
		}

		return returnSugg;

	}


	//Replaces each letter in the word with a new letter
	public ArrayList<String> sugg4(String word)
	{
		ArrayList<Character> chars = new ArrayList<Character>();
		ArrayList<String> suggList = new ArrayList<String>();

		String temp="";

		for(int a=0; a<word.length(); a++)
		{
			chars.add(word.charAt(a));
		}


		for(int i=0; i<word.length(); i++)
		{

			for( char j = 'a'; j <= 'z'; j++ )
			{
				chars.remove(i);

				chars.add(i, j);

				for(int a= 0; a < chars.size();a++)
				{
					temp += chars.get(a);
				}

				suggList.add(temp);

				chars.removeAll(chars);

				for(int a=0; a<word.length(); a++)
				{
					chars.add(word.charAt(a));
				}
				temp ="";
			}


		}

		return suggList;
	}

	//Adding a space between each adjacent letters
	public ArrayList<String> sugg5(String word)
	{
		String st1;
		String st2;
		String st3;
		ArrayList<String> sugg = new ArrayList<String>();


		for(int i =0; i<word.length(); i++)
		{

			st1 = word.substring(0,i);
			st2 = word.substring(i, word.length());

			if(wordList.lookup(st1) && wordList.lookup(st2))
			{
				st3 = st1+" "+st2;
				sugg.add(st3);
			}
		}

		return sugg;

	}


	public  void removeDuplicate(ArrayList arlList)
	{
		HashSet h = new HashSet(arlList);
		arlList.clear();
		arlList.addAll(h);
	}

	// getSuggestions() returns an ArrayList of Strings containing the
	// suggestions for the given word.  If there are no suggestions for
	// the given word, an empty ArrayList of Strings (not null!) should
	// be returned.
	public ArrayList<String> getSuggestions(String word)
	{
		ArrayList<String> suggMain = new ArrayList<String>();

		String temp;

		ArrayList<String> tempList2 = new ArrayList<String>();
		ArrayList<String> tempList3 = new ArrayList<String>();
		ArrayList<String> tempList4 = new ArrayList<String>();
		ArrayList<String> tempList5 = new ArrayList<String>();


		if(word.length() <= 1)
		{

			if(wordList.lookup(word))
			{
				System.out.println(word);
				suggMain.add(word);
				return suggMain;
			}

		}
		else
		{

			temp = sugg1(word);
			if(wordList.lookup(temp))
			{
				suggMain.add(temp);
			}



			tempList2 = sugg2(word);
			for(int i=0; i<tempList2.size(); i++)
			{
				if(wordList.lookup(tempList2.get(i)))
				{
					suggMain.add(tempList2.get(i));
				}
			}




			tempList3 = sugg3(word);
			for(int i=0; i<tempList3.size(); i++)
			{
				if(wordList.lookup(tempList3.get(i)))
				{
					suggMain.add(tempList3.get(i));
				}
			}


			tempList4= sugg4(word);
			for(int i=0; i<tempList4.size(); i++)
			{

				if(wordList.lookup(tempList4.get(i)))
				{
					suggMain.add(tempList4.get(i));
				}
			}


			tempList5 = sugg5(word);
			for(int i=0; i<tempList5.size(); i++)
			{
				suggMain.add(tempList5.get(i));
			}



		}

		String s1;
		String s2;
		
		for (int i = 0; i < suggMain.size(); i++)
		{
			s1 = suggMain.get(i);
			
				for (int j = i + 1; j < suggMain.size(); j++)
				{
					
					s2 = suggMain.get(j);
					
						if(s1.equals(s2))
						{

							suggMain.remove(i);
						}
					
				}

			
		}


		return suggMain;


	}
}