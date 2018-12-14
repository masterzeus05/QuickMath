package Games;
import java.util.List;
import java.util.Arrays;

public class QuickMath{
    int _score = 0;
    int _games = 10;
    String _currentChallenge;
    int _currentResult;
    List<String> _operators = Arrays.asList("+", "-", "*", "/");

    public QuickMath(int games){
        _games = games;
    }

    public boolean hasNext(){
        return _games>0;
    }

    public String getChallenge(){
        int num1, num2;
        String operator = _operators.get((int)(Math.random()*_operators.size()));
        if (operator.equals("/")){
            num2 = (int) (Math.random()*20+1);
            num1 = (int) (Math.random()*5) * num2;
            _currentResult = num1/num2;
        }
        else{
            num1 = (int) (Math.random()*20);
            num2 = (int) (Math.random()*20);
            switch (operator){
                case "+": _currentResult = num1+num2; break;
                case "-": _currentResult = num1-num2; break;
                case "*": _currentResult = num1*num2; break;
            }
        }
        _currentChallenge = num1+operator+num2;
        _games--;
        return num1+operator+num2;
    }

    public String setAnswer(String response){
        int res = Integer.parseInt(response);
        if (res == _currentResult){
            _score++;
            return "Correct!";
        }
        else return "Incorrect...";

    }

    public int getScore(){
        return _score;
    }
}