package Games;

public interface Game{
    public String getChallenge();
    public boolean hasNext();
    public String setAnswer(String response);
    public int getScore();
}