
import java.util.ArrayList;


public class PaperRoll
{
     private double meters;

     public PaperRoll()
     {
        this.meters = 1000;
    }

    public double getMeters()
    {
        return meters;
    }

}

class Machine
{
    private PaperRoll paper;

    public Machine(PaperRoll roll)
    {
        paper = roll;
    }

    public PaperRoll getPaperRoll()
    {
        return paper;
    }

    public PaperRoll replacePaper(PaperRoll pRoll)
    {
        PaperRoll oldRoll = paper;
        paper = pRoll;
        return oldRoll;
    }
}

class PrintingFactory
{
    private Machine[] machines;

    private ArrayList<PaperRoll> newRolls = new ArrayList<PaperRoll>();
    private ArrayList<PaperRoll> usedRolls = new ArrayList<PaperRoll>();

    public PrintingFactory(int numMachines)
    {
        machines = new Machine[numMachines];
    }

    //removes paper rolls in close-to-empty machines
    //takes one out of new rolls, adds old roll to used rolls
    public void replacePaperRolls()
    {
        for(Machine machine : machines)
        {
            PaperRoll macPap = machine.getPaperRoll();

            if(macPap.getMeters() < 4 && newRolls.size() > 0 )
            {
                machine.replacePaper(newRolls.get(0));
                usedRolls.add(macPap);
                newRolls.remove(0);
            }
        }
    }

    //get total paper used in job cycle
    public double getPaperUsed()
    {
        double totalMetersUsed = 0;
        for(PaperRoll pap : usedRolls)
        {
            totalMetersUsed += (1000 - pap.getMeters());
        }

        for(Machine machine : machines)
        {
            totalMetersUsed += (1000 - machine.getPaperRoll().getMeters());
        }

        return totalMetersUsed;
    }
}
