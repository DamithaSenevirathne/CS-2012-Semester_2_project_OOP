import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.lang.Thread;



interface RealWorldThing {
	
	public String name();
	public int posX();
	public int posY();
	/*abstract method to place Real world things in a 2D array*/
	public void place(RealWorldThing[][] lake);
	
}


interface Inhabitant extends RealWorldThing{

}


abstract class Human implements Inhabitant{
	protected String name;
	protected int pX;
	protected int pY;
    protected boolean isAlive=true;
    protected boolean swimFin=true;
    protected boolean immortal = false;    
    
	
    
    public Human(String name1){
       	name=name1;
    }
    
    public String name(){
    	return name;
    	
    }

	/*start points*/
    
    public void begin(){
		int[] choice = {0,1};
		int[] coordinates = {0,1,2,3,4,5,6,7,8,9,10};
    	Random rand = new Random();
    	int x = rand.nextInt(choice.length);
    	int x1=choice[x];
    	if (x1==1){
    		pY=0;
    		Random rand1 = new Random();
        	int x2 = rand1.nextInt(coordinates.length);
        	int x3=coordinates[x2];
        	pX=x3;
    	}else{
    		pX=0;
    		Random rand1 = new Random();
        	int y2 = rand1.nextInt(coordinates.length);
        	int y3=coordinates[y2];
        	pY=y3;
    	}
    	
    	System.out.print(name+" STARTED AT "+pX);
		System.out.print(" "+pY);
		System.out.println(" ");
		
	}
    
	/*move method*/
    public void move(){
    	
    	boolean isTrue=true;
    	
    	while (isTrue){
	    	int[] array = {1,2,3,4};
	    	Random rand = new Random();
	    	int i = rand.nextInt(array.length);
	    	int j=array[i];
	    	
	    	
	    	if (j==1){
	    		if (pX<10){
	    			pX+=1;
	    			isTrue=false;
	    		}
	    	}
	    	else if (j==2){
	    		if (0<pX){
	    			pX-=1;
	    			isTrue=false;
	    		}
	    	}
	    	else if (j==3){
	    		if (pY<10){
	    			pY+=1;
	    			isTrue=false;
	    		}
	    	}
	    	else{
	    		if (0<pY){
	    			pY-=1;
	    			isTrue=false;
	    		}
	    	}    	
    	
	    	
    	}
    	
    }  
    
    
	public int posX(){
		return pX;
		
	}
	public int posY(){
		return pY;
		
	}
	
	public void setX(int posX){
		pX=posX;
	}
	
	public void setY(int posY){
		pY=posY;
	}
	
	public void killed(){
		isAlive=false;	
	}
	
	public boolean getIsAlive(){
		return isAlive;	
	}
	
	public void lostSwimFins(){
		swimFin=false;
	}
	
	public boolean returnSwimFin(){
		return swimFin;
	}
	
	public void plucLotus(){
		immortal=true;
		
	}
	
	public boolean returnImmortal(){
		return immortal;
	}
	
	
	
        
    public abstract void eat();
    
    public abstract void swim();
    
    public abstract void sleep();

	
    
}



class Warrior extends Human{
	
	private boolean isWin= false;
	        
    private int warrior_id;
    private static int numberOfWarriros=0;
    
    public Warrior(String name1){
		super(name1);
		warrior_id=++numberOfWarriros;
	}
    

	/*Calculating the Elapsed time*/
    final long startTime = System.nanoTime();
	

	
	public void startDetail(){
		System.out.print(posX());
		System.out.print(" "+posY());
		System.out.println("");
	}
	
	public void getChest(){
		isWin=true;
		
	}
	
	public boolean returnGetChest(){
		return isWin;
	}
	      
    
        
	public void printDetail(){
		System.out.println(isAlive);
	}
	
	        
    public static int getNumberOfWarriors(){
    	return numberOfWarriros;
    }
        
    public int getId(){
    	return warrior_id;
    }


	@Override
	public void eat() {
		// TODO Auto-generated method stub
	}


	@Override
	public void swim() {
		// TODO Auto-generated method stub
	}


	@Override
	public void sleep() {
		// TODO Auto-generated method stub
	}


	@Override
	public void place(RealWorldThing[][] lake) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void getMessageFromChest(){
		if (isWin==true){
			
			final long duration = System.nanoTime() - startTime;
			
			System.out.println("================ ** GAME OVER ** ======================");
			System.out.println("============== *** GAME IS WON BY *** "+this.name+" ==============");
			System.out.println(" GAME-PLAY DURATION "+duration/(1000000)+" ms ");
			
			System.out.println("=================================================");
			
			String numberAsString = new Long(duration/(1000000)).toString();
			String content = " WINNER IS " + this.name()+" AND ElAPSED TIME IS "+numberAsString + "ms";
			File file = new File("result.txt");
			FileWriter filewriter = null;
			try {
				filewriter = new FileWriter(file.getAbsoluteFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
			BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
			try {
				bufferedWriter.write(content);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			} 
			
		}else{
			System.out.println(this.name + " GAVE UP !!!! SOMEONE GOT THE CHEST");
		}
		
	}


	


	


	


	


}

class SuperWarrior extends Warrior{
    
	public SuperWarrior(String name) {
        	super(name);
	}
    @Override
    public void eat(){
    	System.out.println("Super warrior eat");
    }
    @Override
    public void sleep(){
		System.out.println("Super warrior sleep");
    	}
    @Override
    public void swim(){
		System.out.println("Super warrior swim");
    }
    
    public void bino(){
    }
    
    
    
    
}



class TreasureChest implements RealWorldThing{
	
	private String name;
    private int pX=5;
    private int pY=5;
    
    Warrior warrior;
    
        
    public TreasureChest(String name){
        	this.name=name;
    }
    
    public String name(){
    	return name;
    }
	public int posX(){
		return pX;
	}
	public int posY(){
		return pY;
	}

	
	public void place(RealWorldThing[][] lake) {
		
		lake[pX][pY] = this;
		
	}
	
	public void notifyWarriors(Warrior warrior){
		warrior.getMessageFromChest();		
	}
	
	
	
}


abstract class Fish implements Inhabitant{
	
	protected String name;
    protected int pX;
    protected int pY;
    
        
    public Fish(String name){
        	this.name=name;
    }
    
    public String name(){
    	return name;
    }
	public int posX(){
		return pX;
	}
	public int posY(){
		return pY;
	}
    
    
    
    
    
}



class Grid{
	
	private ArrayList<RealWorldThing> List;
	private ArrayList<Inhabitant> inhabitantList;
	private ArrayList<Warrior> WarriorList;
	private ArrayList<RealWorldThing> placeList;
	
	private Warrior[][] warriorLake;
	private RealWorldThing[][] surround;
	
	
	
	public Grid(){}
			
		
	public void genarteSurround(){

		/*initailizing the varibles*/
		
		warriorLake = new Warrior[11][11];
		surround = new RealWorldThing[11][11];
		
				
		
		Warrior warrior_A = new Warrior("A");
		Warrior warrior_B = new Warrior("B");
	    Warrior warrior_C = new Warrior("C");
	    Warrior warrior_D = new Warrior("D");
	        
	    
	    RealWorldThing flower_A = new LotusFlower("flower_A");
	    RealWorldThing flower_B = new LotusFlower("flower_B");
	    RealWorldThing flower_C = new LotusFlower("flower_C");
	    RealWorldThing flower_D = new LotusFlower("flower_D");
	    RealWorldThing flower_E = new LotusFlower("flower_E");
	        
	    
	    RealWorldThing nfish_A = new NormalFish("nfish_A");
	    RealWorldThing nfish_B = new NormalFish("nfish_B");
	    RealWorldThing kfish_A = new KillerFish("kfish_A");
	    RealWorldThing kfish_B = new KillerFish("kfish_B");
	    RealWorldThing rfish_A = new RubberFish("rfish_A");
	    RealWorldThing rfish_B = new RubberFish("rfish_B");
	    
	    RealWorldThing chest = new TreasureChest("Chest");
	    
	    //adding Warrior objects to the ArrayList
	    
	    WarriorList = new ArrayList<Warrior>();
	    inhabitantList = new ArrayList<Inhabitant>();
	    List = new ArrayList<RealWorldThing>();
	    placeList = new ArrayList<RealWorldThing>();
	    
	    List.add(warrior_A);
	    List.add(warrior_B);
	    List.add(warrior_C);
	    List.add(warrior_D);
	    
	    
	    //adding Flower objects to the ArrayList
	    List.add(rfish_A);
	    List.add(rfish_B);
	    List.add(nfish_A);
	    List.add(nfish_B);
	    List.add(kfish_A);
	    List.add(kfish_B);
	    
	    //adding LotusFlower objects to the ArrayList
	    List.add(flower_A);
	    List.add(flower_B);
	    List.add(flower_C);
	    List.add(flower_D);
	    List.add(flower_E);
	    
	    List.add(chest);
	    
	    //keeping the track of number of inhabitants
	    
	    	    
	    for (int i=0 ; i<List.size();++i){
	        if (List.get(i) instanceof Inhabitant){
	        	inhabitantList.add((Inhabitant) List.get(i));
	        }
	    }
	    
	    for (int i=0 ; i<List.size();++i){
	        if (List.get(i) instanceof Warrior){
	        	WarriorList.add((Warrior) List.get(i));
	        	
	        	
	        }else{
	        	List.get(i).place(surround);
	        	placeList.add(List.get(i));
	        	
	        	
	        }
	    }
	    
	    
	    
	    
	     
	    		
	}
	
	public ArrayList<Warrior> returnWarriorList(){
		return WarriorList;
	}
	
	public ArrayList<Inhabitant> returnInhabitantList(){
		return inhabitantList;
	}

	public ArrayList<RealWorldThing> returnList(){
		return List;
	}

	public ArrayList<RealWorldThing> returnplaceList(){
		return placeList;
	}
	
	public Warrior[][] returnWarriorPoints(){
		return warriorLake;
	}
	
	public RealWorldThing[][] returnSurround(){
		return surround;
	}
	
	

}


class LotusFlower implements RealWorldThing{
	private int lotusCount=100;
    protected String name;
    private int pX;
    private int pY;
    public LotusFlower(String name1){
    	name=name1;
    }
    
    public String name(){
    	return name;
    }
    
    public int posX(){
    	return pX;    	
    }
    
    public int posY(){
    	return pY;
    }
    
    
    public void place(RealWorldThing[][] lake){
    	
    	while (true){
    	
	    	int[] array = {0,1,2,3,4,5,6,7,8,9,10};
	    	Random randX = new Random();
	    	int x1 = randX.nextInt(array.length);
	    	pX=array[x1];
	    	Random randY = new Random();
	    	int y1 = randY.nextInt(array.length);
	    	pY=array[y1];
	    	
	    	if (lake[pX][pY] == null){
	    		lake[pX][pY] = this;
	    		break;
	    	}
	    	
    	
    	}
    
    }
    
    
    
    
    public void detail(){
    	System.out.println(pX);
    	System.out.println(pY);
    	
    }
    
    public void plucLotus(){
    	--lotusCount;     	
        	
    }
    	
    public int numberOfPelts(){
    	return lotusCount;
    } 
}



class KillerFish extends Fish{

	public KillerFish(String name) {
        	super(name);
    }    
            
    
    public void place(RealWorldThing[][] lake){
    	
    	while (true){
    	
	    	int[] array = {0,1,2,3,4,5,6,7,8,9,10};
	    	Random randX = new Random();
	    	int x1 = randX.nextInt(array.length);
	    	pX=array[x1];
	    	Random randY = new Random();
	    	int y1 = randY.nextInt(array.length);
	    	pY=array[y1];
	    	
	    	if (lake[pX][pY] == null){
	    		lake[pX][pY] = this;
	    		break;
	    	}
	    	
    	
    	}
    
    }
    
	public void kill(Warrior warrior){
			
			if (warrior.getIsAlive() ==true){
				warrior.killed();
			}
			
	}
    
}



class NormalFish extends Fish{

	public NormalFish(String name) {
		super(name);
		
	}

	
	public void place(RealWorldThing[][] lake) {
			    	
	    	while (true){
	    	
		    	int[] array = {0,1,2,3,4,5,6,7,8,9,10};
		    	Random randX = new Random();
		    	int x1 = randX.nextInt(array.length);
		    	pX=array[x1];
		    	Random randY = new Random();
		    	int y1 = randY.nextInt(array.length);
		    	pY=array[y1];
		    	
		    	if (lake[pX][pY] == null){
		    		lake[pX][pY] = this;
		    		break;
		    	}
		    	
	    	
	    	}
	    
	    
		
	}
	

}



class RubberFish extends Fish{
	public RubberFish(String name){
		super(name);
	}
	
	public void place(RealWorldThing[][] lake){
    	
    	while (true){
    	
	    	int[] array = {0,1,2,3,4,5,6,7,8,9,10};
	    	Random randX = new Random();
	    	int x1 = randX.nextInt(array.length);
	    	pX=array[x1];
	    	Random randY = new Random();
	    	int y1 = randY.nextInt(array.length);
	    	pY=array[y1];
	    	
	    	if (lake[pX][pY] == null){
	    		lake[pX][pY] = this;
	    		break;
	    	}
	    	
    	
    	}
    
    }
	
	public void eatFins(Warrior warrior){
		
		if (warrior.returnSwimFin() ==true){
			warrior.lostSwimFins();
		}
		
	}
	
	
}







class Player implements Runnable{
	
	final long startTime = System.nanoTime();
	
	
	
	Warrior warrior;
	RealWorldThing[][] lakeNozama;
	volatile Warrior[][] lakeOfWarriors;
	ArrayList<Warrior> WarriorList;
	
	
	public Player(Warrior warrior,RealWorldThing[][] lakeNozama,Warrior[][] lakeOfWarriors,ArrayList<Warrior> WarriorList){
		
		this.lakeNozama = lakeNozama;
		this.warrior = warrior;
		this.lakeOfWarriors = lakeOfWarriors;
		this.WarriorList=WarriorList;
		
	}

	@Override
	public void run() {
		
		synchronized(this){
			
		
			
		while(true){
			
		if (WarriorList.get(0).returnGetChest() || WarriorList.get(1).returnGetChest() || WarriorList.get(2).returnGetChest() || WarriorList.get(3).returnGetChest()){
			break;
		}
		if (!(WarriorList.get(0).getIsAlive() || WarriorList.get(1).getIsAlive() || WarriorList.get(2).getIsAlive() || WarriorList.get(3).getIsAlive())){
				System.out.println("GAME OVER ALL ARE ELIMINATED");
				final long duration = System.nanoTime() - startTime;
			
				String numberAsString = new Long(duration/(1000000)).toString();
				
			
				
				//String numberAsString = new Long(duration/(1000000)).toString();
				String content = "**GAME OVER**\n***ALL PLAYERS ELIMINATED***\n" +"ELAPSED TIME IS "+numberAsString + "ms";
				
				File file = new File("result.txt");
				FileWriter filewrite = null;
				
				try {
					filewrite = new FileWriter(file.getAbsoluteFile());
				} catch (IOException e) {
					e.printStackTrace();
				}
				BufferedWriter bufferedwriter = new BufferedWriter(filewrite);
				try {
					bufferedwriter.write(content);
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					bufferedwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			break;
		}
		if  ((lakeNozama[warrior.posX()][warrior.posY()] instanceof LotusFlower) && ((warrior.returnImmortal())!=true)){
			warrior.plucLotus();
			System.out.println(warrior.name()+" PLUCKS OUT A LOTUS PETAL !!! NOW "+warrior.name()+" IS IMMORTAL !!! ");
		}else if ((lakeNozama[warrior.posX()][warrior.posY()] instanceof RubberFish) && ((warrior.returnSwimFin())!=false)){
			((RubberFish) lakeNozama[warrior.posX()][warrior.posY()]).eatFins(warrior);
			warrior.killed();
			System.out.println(warrior.name()+" CAN'T SWIM !!! RUBBER FISH ATTACKED");
			break;
		}else if ((lakeNozama[warrior.posX()][warrior.posY()] instanceof KillerFish) && (warrior.getIsAlive()==true)){
			if (warrior.returnImmortal()==false){
				((KillerFish) lakeNozama[warrior.posX()][warrior.posY()]).kill(warrior);;
				warrior.lostSwimFins();
				System.out.println(warrior.name()+" IS KILLED BY A KILLERFISH");
				break;
			}
		}else if (lakeNozama[warrior.posX()][warrior.posY()] instanceof TreasureChest){
			warrior.getChest();
			((TreasureChest)lakeNozama[warrior.posX()][warrior.posY()]).notifyWarriors(WarriorList.get(0));
			((TreasureChest)lakeNozama[warrior.posX()][warrior.posY()]).notifyWarriors(WarriorList.get(1));
			((TreasureChest)lakeNozama[warrior.posX()][warrior.posY()]).notifyWarriors(WarriorList.get(2));
			((TreasureChest)lakeNozama[warrior.posX()][warrior.posY()]).notifyWarriors(WarriorList.get(3));
			
			
		}
		if (warrior.returnGetChest()==false){
		
			if ((warrior.getIsAlive() && warrior.returnSwimFin())==true){
				while (true){
					int temp_x=warrior.posX();
					int temp_y=warrior.posY();
										
					if ((warrior.posX()==5) && (warrior.posX()==4)){
						warrior.getChest();
						System.out.println(warrior.name()+" IS THE WINNER");
						break;
					}
					if ((warrior.posX()==4) && (warrior.posX()==5)){
						warrior.getChest();
						System.out.println(warrior.name()+" IS THE WINNER");
						break;
					}
					if ((warrior.posX()==5) && (warrior.posX()==6)){
						warrior.getChest();
						System.out.println(warrior.name()+" IS THE WINNER");
						break;
					}
					if ((warrior.posX()==6) && (warrior.posX()==5)){
						warrior.getChest();
						System.out.println(warrior.name()+" IS THE WINNER");
						break;
					}
					warrior.move();
					
								
					
					
					if (lakeOfWarriors[warrior.posX()][warrior.posY()] == null){
						//refreshing 
						
						System.out.println(warrior.name()+" SWIMS TO "+warrior.posX()+" "+warrior.posY());
						
						
						for (int a=0;a<11;++a){
					    	for (int b=0;b<11;++b){
					    		if (lakeOfWarriors[a][b]==warrior){
					    			lakeOfWarriors[a][b]=null;
					    			break;
					    		}
					    		   			    		
					    	}
					    }
						lakeOfWarriors[warrior.posX()][warrior.posY()] = warrior;
						break;    			
					}else{
						
						warrior.setX(temp_x);
						warrior.setY(temp_y);
						System.out.println("OOPS " + warrior.name() +" CANT GO !!! SOMEONE IS THERE !!");
						
						
					}
				}	
			}
			
			
			
	
		}else{
			
			break;
		}
		
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}	
		
	}
		
	}
		
	
	
	}
}




public class GameDemo{
	
	/*static method to implement the game-play*/
	
	public static void main( String[] args) throws InterruptedException{
		
				
		System.out.println("======================================");
		System.out.println("======== CREATED BY 160576B ==========");
		System.out.println("=========== D.B.SENEVIRATHNE =========");
		System.out.println("============== CSE ===================");
		
		
		
		ArrayList<Warrior> warriorList;
		RealWorldThing[][] lakeNozama;
		Warrior[][] lakeOfWarriors;		
		
		Grid lake = new Grid();
		lake.genarteSurround();
		
		warriorList = lake.returnWarriorList();
		lakeNozama = lake.returnSurround();
		lakeOfWarriors = lake.returnWarriorPoints();
		
		//for (int i=0;i<11;++i){
			//for (int j=0;j<11;++j){
				//if (lakeNozama[i][j]!= null){
					//System.out.print("\t"+lakeNozama[i][j].name()+"\t"+"\t");
					
				//}else{
					//System.out.print("\t0\t");
				//}
			//}
			
			//System.out.println("\t");
		//}
		
		
		
		
		System.out.println("****************GAME STATS******************\n");
		
		
	    /*output the number of inhabitants*/
	    //System.out.println("COUNT OF INHABITANTS : " + inhabitantList.size());
		
			    
	       
	    /*Number of Warriors using static method*/
	    System.out.println("NUMBER OF WARRIORS : "+Warrior.getNumberOfWarriors());
	    
	        
	    
	    
	    System.out.println("=======================================");
	    	    
	    
	    
	    System.out.println("\n********Game Started********\n");
	    
	    
	    
	    /*Starting points of the Warriors*/
	    
	    for (int i=0;i<warriorList.size();++i){
	    	warriorList.get(i).begin();
	    }
	    
	    

		/*starting Threads*/
	    
	    
	    Thread t1 = new Thread(new Player(warriorList.get(0),lakeNozama,lakeOfWarriors,warriorList));
	    Thread t2 = new Thread(new Player(warriorList.get(1),lakeNozama,lakeOfWarriors,warriorList));
	    Thread t3 = new Thread(new Player(warriorList.get(2),lakeNozama,lakeOfWarriors,warriorList));
	    Thread t4 = new Thread(new Player(warriorList.get(3),lakeNozama,lakeOfWarriors,warriorList));
	    
		/*start running Threads*/
	     
	    
	    t1.start();
	    t2.start();
	    t3.start();
	    t4.start();
	    
	    
	    
	    	     
	    
	    
	    
    
	}
}