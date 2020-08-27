package cricketleagueanalyser;

import org.junit.Assert;
import org.junit.Test;

public class CricketLeagueAnalyserTest {
    private static final String IPL_MOST_RUN_CENSUS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_MOST_WKTS_CENSUS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";
    //This test case is used to ensure number of record matches from IPLMostRuns CSV file
    @Test
    public void givenIPLMostRunsCSVFileReturnsCorrectRecords() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int numOfRecords = cricketLeagueAnalyser.loadIPLCensusData(CricketLeagueAnalyser.Play.BATTING, IPL_MOST_RUN_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(100,numOfRecords);
        } catch (CricketLeagueAnalyserException e) { }
    }
    //This test case is used to ensure number of record matches from IPLMostRuns CSV file
    @Test
    public void givenIPLMostWktsCSVFileReturnsCorrectRecords() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int numOfRecords = cricketLeagueAnalyser.loadIPLCensusData(CricketLeagueAnalyser.Play.BOWLING, IPL_MOST_WKTS_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(99,numOfRecords);
        } catch (CricketLeagueAnalyserException e) { }
    }
}
