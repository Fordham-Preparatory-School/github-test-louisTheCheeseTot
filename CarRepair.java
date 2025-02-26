
import java.util.ArrayList;

public class CarRepair
{
    private int mechanicNum;
    private int bayNum;

    public CarRepair(int m, int b)
    {
    mechanicNum = m;
    bayNum = b;
    }

    public int getMechanicNum()
    { return mechanicNum; }

    public int getBayNum()
    { return bayNum; }
    // There may be other instance variables, constructors, and methods
}

class RepairSchedule
{
    private ArrayList<CarRepair> schedule;
    private int numberOfMechanics;

    public RepairSchedule(int n)
    {
    schedule = new ArrayList<CarRepair>();
    numberOfMechanics = n;
    }

    //checks if bay or mechanic is in schedule. if it is, we cant add repair with
    //inputted mechanic and bay
    public boolean addRepair(int m, int b)
    {
        for(CarRepair p : schedule)
        {
            if(p.getMechanicNum() == m || p.getBayNum() == b)
                return false;
        }

        return true;
    }

    //goes through all of schedule. if we've surpassed schedule's size,
    //then add all of the mechanics not in today's schedule since they're
    //active. if not check if mechanic is in schedule; if he isn't, add him to list
    public ArrayList<Integer> availableMechanics()
    {
        ArrayList<Integer> ava = new ArrayList<Integer>();

        for(int i =0;i<numberOfMechanics;i++)
        {
            if(schedule.size() > numberOfMechanics)
            {
                ava.add(i);
            }
            else if(schedule.get(i).getMechanicNum() != i)
            {
                ava.add(i);
            }
        }

        return ava;
    }
}
