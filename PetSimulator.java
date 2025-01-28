/*
* Activity 3.6.3
*/
public class PetSimulator
{

    public static void main(String[] args)
    {
        Pet pet1 = new Pet("Spot", 2);
        Pet pet2 = new Pet("Kaiden", 1);
        Pet pet3 = new Pet("Tyler Williams", 1);
        Pet pet4 = new Pet("Noone", 2);

        Pet[] allThePets = {pet1,pet2,pet3,pet4,null,null,null,null,null,null};

        //set owner of all pets to me
        for(Pet pet : allThePets)
        {
            if(pet != null)
                pet.setOwner("Louis");
        }

        
        //let's get the status of all the pets before we do anything to them
        System.out.println("--- MY PETS BEFORE---");
        for(Pet pet : allThePets)
        {
            if(pet != null)
                System.out.println(pet.toString());
        }

        //feed all pets
        for(Pet pet : allThePets)
        {
            if(pet != null)
            {
                pet.feed();
                pet.setOwner("Louis");
            }
        }

        //make all dogs bark, walk them
        for(Pet pet : allThePets)
        {
            if(pet != null && pet.getType() == 2)
            {
                pet.makeNoise();
                pet.walk();
            }
        }

        //make all cats meow
        for(Pet pet : allThePets)
        {
            if(pet != null && pet.getType() == 1)
            {
                pet.makeNoise();
            }
        }

        //give all pets a treat
        for(Pet pet : allThePets)
        {
            if(pet != null)
            {
                pet.giveTreat();
            }
        }

        //groom cats
        for(Pet pet : allThePets)
        {
            if(pet != null && pet.getType() == 1)
            {
                pet.groom();
            }
        }

        //play with all pets
        for(Pet pet : allThePets)
        {
            if(pet != null)
            {
                pet.play();
            }
        }

        //nap and feed all pets
        for(Pet pet : allThePets)
        {
            if(pet != null && pet.getType() == 1)
            {
                pet.sleep();
                pet.feed();
            }
        }

        //add more pets
        allThePets[4] = new Pet("Brian Frads", 1);
        allThePets[5] = new Pet("Desmos Graphing Calculator", 2);

        //give the pets an owner
        for(Pet pet : allThePets)
        {
            if(pet != null)
                if(pet.getOwner() == null)
                    pet.setOwner("Siuol");
        }

        System.out.println();
        System.out.println("--- MY PETS AFTER---");

        for(Pet pet : allThePets)
        {
            if(pet != null)
                System.out.println(pet.toString());
        }
    }
}
