package cricketleagueanalyser;

public class IPLCensusDAO {
    public String player;
    public int runs;
    public double average;
    public double strikeRate;
    public int century;
    public int halfCentury;
    public int fours;
    public int sixes;
    public int wickets;
    public int bowling;
    public double economy;
    public int fourWickets;
    public int fiveWickets;

    public IPLCensusDAO(IPLMostRunsCensusCSV iplMostRunsCensusCSV) {
        player = iplMostRunsCensusCSV.player;
        runs = iplMostRunsCensusCSV.runs;
        average = iplMostRunsCensusCSV.average;
        strikeRate = iplMostRunsCensusCSV.strikeRate;
        century = iplMostRunsCensusCSV.century;
        halfCentury = iplMostRunsCensusCSV.halfCentury;
        fours = iplMostRunsCensusCSV.fours;
        sixes = iplMostRunsCensusCSV.sixes;
    }
    public IPLCensusDAO(IPLMostWktsCensusCSV iplMostWktsCensusCSV) {
        player = iplMostWktsCensusCSV.player;
        runs = iplMostWktsCensusCSV.runs;
        wickets = iplMostWktsCensusCSV.wickets;
        bowling = iplMostWktsCensusCSV.bowling;
        average = iplMostWktsCensusCSV.average;
        economy = iplMostWktsCensusCSV.economy;
        strikeRate = iplMostWktsCensusCSV.strikeRate;
        fourWickets = iplMostWktsCensusCSV.fourWickets;
        fiveWickets = iplMostWktsCensusCSV.fiveWickets;
    }
}
