public class HiddenWord {
    private String hiddenWord;

    public HiddenWord(String hiddenWord)
    {
        this.hiddenWord = hiddenWord.toUpperCase();
    }

    public String getHint(String guess)
    {
        String str = "";
        if (!guess.toUpperCase().equals(guess))
        {
            throw new IllegalArgumentException ("Your guess ( " + guess + " ) does not contain all uppercase letters. Your guess must contain all uppercase letters!");
        }
        if (guess.length() != hiddenWord.length())
        {
            throw new IllegalArgumentException("Your guess ( " + guess + " ) has " + guess.length() + " characters. The hidden word has " + hiddenWord.length() + " characters. Your guess must be a word with " + hiddenWord.length() + " characters!");
        }
        for (int i = 0; i < guess.length(); i++) {
            boolean charAdded = false;
            if (guess.charAt(i) == hiddenWord.charAt(i))
            {
                str += guess.charAt(i);
                System.out.println("Correct letter!");
            }
            else
            {
                for (int j = 0; j < guess.length(); j++) {
                    if (!charAdded && guess.charAt(i) == hiddenWord.charAt(j) && i != j) {
                        str += "+";
                        charAdded = true;
                    }
                }
                if (!charAdded)
                {
                    str += "*";
                }
            }
        }
        return str;
    }

    public String getHiddenWord()
    {
        return hiddenWord;
    }
}
