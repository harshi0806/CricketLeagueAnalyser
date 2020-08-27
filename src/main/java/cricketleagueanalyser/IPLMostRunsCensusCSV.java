package cricketleagueanalyser;

import com.opencsv.bean.CsvBindByName;

public class IPLMostRunsCensusCSV {

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "Avg", required = true)
    public double average;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRate;

    @CsvBindByName(column = "100", required = true)
    public int century;

    @CsvBindByName(column = "50", required = true)
    public int halfCentury;

    @CsvBindByName(column = "4s", required = true)
    public int fours;

    @CsvBindByName(column = "6s", required = true)
    public int sixes;

    @Override
    public String toString() {
        return "IPLMostRunsCensusCSV{" +
                "PLAYER='" + player + '\'' +
                ", Runs='" + runs + '\'' +
                ", Avg='" + average + '\'' +
                ", SR='" + strikeRate + '\'' +
                ", 100='" + century + '\'' +
                ", 50='" + halfCentury + '\'' +
                ", 4s='" + fours + '\'' +
                ", 6s='" + sixes + '\'' +
                '}';
    }
}
