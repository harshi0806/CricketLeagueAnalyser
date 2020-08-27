package cricketleagueanalyser;

public class CricketLeagueAnalyserException extends Exception {
    enum ExceptionType{
        CENSUS_FILE_PROBLEM, CENSUS_INCORRECT_HEADER, INVALID_PLAY
    }
    ExceptionType type;
    public CricketLeagueAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
    public CricketLeagueAnalyserException(String message, String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }
}
