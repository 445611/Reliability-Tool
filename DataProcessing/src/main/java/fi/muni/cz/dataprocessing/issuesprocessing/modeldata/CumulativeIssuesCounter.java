package fi.muni.cz.dataprocessing.issuesprocessing.modeldata;

import fi.muni.cz.dataprovider.GeneralIssue;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.util.Pair;

/**
 * @author Radoslav Micko, 445611@muni.cz
 */
public class CumulativeIssuesCounter implements IssuesCounter {

    private IssuesCounter counter;
    
    /**
     * Initialize attributes to default value.
     * Defaul value is one week.
     */
    public CumulativeIssuesCounter() {
        counter = new IntervalIssuesCounter(WEEKS);
    }
    
    /**
     * Initialize attributes to certain values.
     * @param typeOfTimeToAdd type of Calendar enum
     */
    public CumulativeIssuesCounter(String typeOfTimeToAdd) {
        counter = new IntervalIssuesCounter(typeOfTimeToAdd);
    }
    
    @Override
    public List<Pair<Integer, Integer>> prepareIssuesDataForModel(
            List<GeneralIssue> listOfIssues) {
        List<Pair<Integer, Integer>> spreadedIssues = getIntervalIssues(listOfIssues);
        Integer totalNumber = 0;
        List<Pair<Integer, Integer>> listOfTotalIssues = new ArrayList<>();
        for (Pair<Integer, Integer> pair: spreadedIssues) {
            totalNumber = totalNumber + pair.getSecond();
            listOfTotalIssues.add(new Pair(pair.getFirst(), totalNumber));
        }
        return listOfTotalIssues;
    }
    
    private List<Pair<Integer, Integer>> getIntervalIssues(List<GeneralIssue> listOfIssues) {
        return counter.prepareIssuesDataForModel(listOfIssues);
    }
}