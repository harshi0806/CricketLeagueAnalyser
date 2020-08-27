package cricketleagueanalyser;

import com.opencsv.bean.CsvBindByName;

public class IPLMostWktsCensusCSV {

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "Wkts", required = true)
    public int wickets;

    @CsvBindByName(column = "BBI", required = true)
    public int bowling;

    @CsvBindByName(column = "Avg", required = true)
    public double average;

    @CsvBindByName(column = "Econ", required = true)
    public double economy;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRate;

    @CsvBindByName(column = "4w", required = true)
    public int fourWickets;

    @CsvBindByName(column = "5w", required = true)
    public int fiveWickets;

    @Override
    public String toString() {
        return "IPLMostRunsCensusCSV{" +
                "PLAYER='" + player + '\'' +
                ", Runs='" + runs + '\'' +
                ", Wkts='" + wickets + '\'' +
                ", BBI='" + bowling + '\'' +
                ", Avg='" + average + '\'' +
                ", Econ='" + economy + '\'' +
                ", SR='" + strikeRate + '\'' +
                ", 4w='" + fourWickets + '\'' +
                ", 5w='" + fiveWickets + '\'' +
                '}';
    }
}
