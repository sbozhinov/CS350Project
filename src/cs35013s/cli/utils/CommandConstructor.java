package cs35013s.cli.utils;
import java.util.LinkedList;

import cs35013s.cli.commands.A_Command;
import cs35013s.cli.commands.actors.ActorCreate;
import cs35013s.cli.commands.actors.ActorDefineAirplane;
import cs35013s.cli.commands.actors.ActorDefineShip;
import cs35013s.cli.commands.actors.ActorDefineSubmarine;
import cs35013s.cli.commands.actors.ActorExecuteManeuver;
import cs35013s.cli.commands.actors.ActorSetAltitude;
import cs35013s.cli.commands.actors.ActorSetCourse;
import cs35013s.cli.commands.actors.ActorSetSpeed;
import cs35013s.cli.commands.actors.ActorUndefine;
import cs35013s.cli.commands.maneuvers.ManeuverDefine;
import cs35013s.cli.commands.maneuvers.ManeuverUndefine;
import cs35013s.cli.commands.misc.Load;
import cs35013s.cli.commands.misc.Pause;
import cs35013s.cli.commands.misc.Resume;
import cs35013s.cli.commands.misc.SetStateTest;
import cs35013s.cli.commands.misc.SetUpdate;
import cs35013s.cli.commands.misc.Wait;
import cs35013s.cli.commands.munitions.MunitionBomb;
import cs35013s.cli.commands.munitions.MunitionDeploy;
import cs35013s.cli.commands.munitions.MunitionDeployAz;
import cs35013s.cli.commands.munitions.MunitionDepth_Charge;
import cs35013s.cli.commands.munitions.MunitionLoad;
import cs35013s.cli.commands.munitions.MunitionMissile;
import cs35013s.cli.commands.munitions.MunitionShell;
import cs35013s.cli.commands.munitions.MunitionTorpedo;
import cs35013s.cli.commands.munitions.MunitionUndefine;
import cs35013s.cli.commands.sensors.SensorDefineAcoustic;
import cs35013s.cli.commands.sensors.SensorDefineDepth;
import cs35013s.cli.commands.sensors.SensorDefineDistance;
import cs35013s.cli.commands.sensors.SensorDefineRadar;
import cs35013s.cli.commands.sensors.SensorDefineSonarActive;
import cs35013s.cli.commands.sensors.SensorDefineSonarPassive;
import cs35013s.cli.commands.sensors.SensorDefineThermal;
import cs35013s.cli.commands.sensors.SensorDefineTime;
import cs35013s.cli.commands.sensors.SensorUndefine;
import cs35013s.cli.commands.views.ViewCreateWindowFront;
import cs35013s.cli.commands.views.ViewCreateWindowSide;
import cs35013s.cli.commands.views.ViewCreateWindowTop;
import cs35013s.cli.commands.views.ViewDeleteWindow;
import cs35013s.cli.commands.views.ViewLockWindow;
import cs35013s.cli.commands.views.ViewUnlockWindow;

public class CommandConstructor {

	
	
	private final A_Command aCommand;
	
	
	public A_Command getCommand() {
		return aCommand;
	}
	
	public CommandConstructor(String originalString){
		
		aCommand = evaluate(originalString);

	}//end constructor()
	

	public A_Command evaluate(String originalString){
		//
		A_Command tempCommand = null;
		// cord: make originalString case-insensitive
		originalString.toLowerCase();
		
		//in case the command is less than the longest eval string, a default array with 100 spots
		String[] str = new String[200];

		String[] temp = originalString.split("\\s+");
        //populates str[]
	    System.arraycopy(temp, 0, str, 0, temp.length);
		
	    //LinkedList and Integer for correct variable creation
	    LinkedList<String> work;
	    int x;
		
		//in alphabetical order, make sure it matches the right command from pdf doc
		//the class to create should match the one I put in comment for each if
		
		//make sure to rename created strings into appropriate ones, refer to PDF
	    
//Views ******************************************************
		
		if(str[0].equals("create") && str[1].equals("window") && str[3].equals("front") ){
			//ViewCreateWindowFront
			tempCommand = new ViewCreateWindowFront(str[2], str[6], 
					str[7].substring(1),str[8], str[9].substring(0, str[9].length()-1),
					str[10].substring(1), str[11],str[12], str[13].substring(0, str[13].length() -1),
					originalString
			);


			
		}
		else if(str[0].equals("create") && str[1].equals("window") && str[3].equals("side") ){
			//ViewCreateWindowSide
			tempCommand = new ViewCreateWindowSide(str[2], str[6], 
					str[7].substring(1),str[8], str[9].substring(0, str[9].length()-1),
					str[10].substring(1), str[11],str[12], str[13].substring(0, str[13].length() -1),
					originalString
			);


			
		}
		else if(str[0].equals("create") && str[1].equals("window") && str[3].equals("top") ){
			//ViewCreateWindowTop
			tempCommand = new ViewCreateWindowTop(str[2], str[6], 
					str[7].substring(1),str[8], str[9].substring(0, str[9].length()-1),
					str[10].substring(1), str[11], str[12].substring(0, str[12].length() -1),
					originalString
					);
						
		}
		else if(str[0].equals("delete") && str[1].equals("window") ){
			//ViewDeleteWindow
			tempCommand = new ViewDeleteWindow(str[2], originalString);

		}
		else if(str[0].equals("lock") && str[1].equals("window") ){
			//ViewLockWindow
			tempCommand = new ViewLockWindow(str[2], str[4], originalString);

		}
		else if(str[0].equals("unlock") && str[1].equals("window") ){
			//ViewUnlockWindow
			tempCommand = new ViewUnlockWindow(str[2], originalString);

		}
		
//Actors ******************************************************
		
		else if(str[0].equals("create") && str[1].equals("actor") ){
			//ActorCreate
			tempCommand = new ActorCreate(str[2], str[4],
					str[6], str[9], str[11],
					originalString);

		}
		else if(str[0].equals("define") && str[1].equals("airplane")  ){

			work= new LinkedList<String>();
			x = 5;
			//Create LinkedList and strip all ()'s to build maneuver list
			while(str[x]!= null)
			{
				str[x] = str[x].replace("(", "");
				work.add(str[x].replace(")", ""));
				x++;
			}

			tempCommand = new ActorDefineAirplane(str[2], work,	originalString);
					
		}
		else if(str[0].equals("define") && str[1].equals("ship") ){
			//ActorDefineShip
			work= new LinkedList<String>();
			x = 5;
			//Create LinkedList and strip all ()'s to build maneuver list
			while(str[x]!= null)
			{
				str[x] = str[x].replace("(", "");
				work.add(str[x].replace(")", ""));
				x++;
			}
			
			tempCommand = new ActorDefineShip(str[2], work,	originalString);
		}
		else if(str[0].equals("define") && str[1].equals("submarine") ){
			//ActorDefineSubmarine
			work= new LinkedList<String>();
			x = 5;
			//Create LinkedList and strip all ()'s to build maneuver list
			while(str[x]!= null)
			{
				str[x] = str[x].replace("(", "");
				work.add(str[x].replace(")", ""));
				x++;
			}
			tempCommand = new ActorDefineSubmarine(str[2], work, originalString);
		}
		else if(str[0].equals("set") && str[2].equals("execute") ){
			//ActorExecuteManeuver
			work= new LinkedList<String>();
			x = 6;
			//Create LinkedList and strip all ()'s to build maneuver list
			while(str[x]!= null)
			{
				str[x] = str[x].replace("(", "");
				work.add(str[x].replace(")", ""));
				x++;
			}
			tempCommand = new ActorExecuteManeuver(str[1], str[4], work, originalString);
			
		}
		else if(str[0].equals("set") && str[2].equals("altitude") ){
			//ActorSetAltitude
			tempCommand = new ActorSetAltitude(str[1],str[3], originalString);
			
		}
		else if(str[0].equals("set") && str[2].equals("course")  ){
			//ActorSetCourse
			tempCommand = new ActorSetCourse(str[1],str[3], originalString);
			
		}
		else if(str[0].equals("set") && str[2].equals("speed") ){
			//ActorSetSpeed
			tempCommand = new ActorSetSpeed(str[1],str[3], originalString);
			
		}
		else if(str[0].equals("undefine") && str[1].equals("actor") ){
			//ActorUndefine
			tempCommand = new ActorUndefine(str[2], originalString);
			
		}
		
//Munitions ****************************************************
		
		else if(str[0].equals("define") && str[1].equals("munition") && str[2].equals("bomb") ){
			//MunitionBomb
			tempCommand = new MunitionBomb(str[3], originalString);
			
		}
		else if(str[0].equals("set") && str[2].equals("deploy") && !str[6].equals("azimuth")   ){
			//MunitionDeploy
			tempCommand = new MunitionDeploy(str[1],str[4], originalString);

		}
		else if(str[0].equals("set") && str[2].equals("deploy") && str[6].equals("azimuth")  ){
			//MunitionDeployAz
			tempCommand = new MunitionDeployAz(str[1],str[4], 
					str[7], str[9], originalString);

		}
		else if(str[0].equals("define") && str[1].equals("munition") && str[2].equals("depth_charge") ){
			//MunitionDepth_Charge
			tempCommand = new MunitionDepth_Charge(str[3],str[6], originalString);

		}
		else if(str[0].equals("set") && str[2].equals("load") && str[3].equals("munition")  ){
			//MunitionLoad
			tempCommand = new MunitionLoad(str[1],str[4], originalString);
			
		}
		else if(str[0].equals("define") && str[1].equals("munition") && str[2].equals("missile") ){
			//MunitionMissile
			tempCommand = new MunitionMissile(str[3],str[6],str[8],str[11], originalString);
		}
		else if(str[0].equals("define") && str[1].equals("munition") && str[2].equals("shell") ){
			//MunitionShell
			tempCommand = new MunitionShell(str[3], originalString);
			
		}		
		else if(str[0].equals("define") && str[1].equals("munition") && str[2].equals("torpedo") ){
			//MunitionTorpedo
			tempCommand = new MunitionTorpedo(str[3],str[6],str[8],str[11], originalString);

		}
		else if(str[0].equals("undefine") && str[2].equals("munition") ){
			//MunitionUndefine
			tempCommand = new MunitionUndefine(str[2], originalString);

		}
		
//Sensors/Fuzes **********************************************
		
		else if(str[0].equals("define") && str[1].equals("sensor") && str[2].equals("acoustic") ){
			//SensorDefineAcoustic
			tempCommand = new SensorDefineAcoustic(str[3],str[6], originalString);

		}
		else if(str[0].equals("define") && str[1].equals("sensor") && str[2].equals("depth") ){
			//SensorDefineDepth
			tempCommand = new SensorDefineDepth(str[3],str[7], originalString);
	
		}
		else if(str[0].equals("define") && str[1].equals("sensor") && str[2].equals("distance") ){
			//SensorDefineDistance
			tempCommand = new SensorDefineDistance(str[3],str[7], originalString);

		}
		else if(str[0].equals("define") && str[1].equals("sensor") && str[2].equals("radar") ){
			//SensorDefineRadar
			tempCommand = new SensorDefineRadar(str[3],str[8], str[10], str[12],originalString);

		}
		else if(str[0].equals("define") && str[1].equals("sensor") && str[2].equals("sonar") && str[3].equals("active") ){
			//SensorDefineSonarActive
			tempCommand = new SensorDefineSonarActive(str[4], str[7], str[9], originalString);
			
		}
		else if(str[0].equals("define") && str[1].equals("sensor") && str[2].equals("sonar") && str[3].equals("passive") ){
			//SensorDefineSonarPassive
			tempCommand = new SensorDefineSonarPassive(str[4], str[7], originalString);
		}
		else if(str[0].equals("define") && str[1].equals("sensor") && str[2].equals("thermal") ){
			//SensorDefineThermal
			tempCommand = new SensorDefineThermal(str[3], str[8],str[10], originalString);
		}
		else if(str[0].equals("define") && str[1].equals("sensor") && str[2].equals("time") ){
			//SensorDefineTime
			tempCommand = new SensorDefineTime(str[3], str[7], originalString);
		}
		else if(str[0].equals("undefine") && str[1].equals("sensor") ){
			//SensorUndefine
			tempCommand = new SensorUndefine(str[2], originalString);
		}
		
		
//Maneuvers **********************************************
		else if(str[0].equals("define") && str[1].equals("maneuver") ){
			//ManeuverDefine
			work= new LinkedList<String>();
			x = 4;
			//Create LinkedList and strip all (")'s to build maneuver list
			while(str[x]!= null)
			{
				str[x] = str[x].replace("(", "");
				str[x+3] = str[x+3].replace(")", "");
				work.add(str[x].replace("\"", "") + " " + str[x+1] + " " + str[x+2] + " " + str[x+3].replace("\"", ""));
				x+=4;
			}
			tempCommand = new ManeuverDefine(str[2], work,	originalString);
		}
		else if(str[0].equals("undefine") && str[1].equals("maneuver") ){
			//ManeuverUnDefine
			tempCommand = new ManeuverUndefine(str[2], originalString);
		}
		
		
//Misc **********************************************
		
		else if(str[0].equals("load") ){
			//Load
			tempCommand = new Load(str[1], this, originalString);

		}
		else if(str[0].equals("pause") ){
			//Pause
			tempCommand = new Pause( originalString);

		}

		else if(str[0].equals("resume") ){
			//Resume
			tempCommand = new Resume( originalString);
			
		}
		else if(str[0].equals("set") && str[1].equals("update") ){
			//SetUpdate
			tempCommand = new SetUpdate(str[2], originalString);
			
		}

		else if(str[0].equals("wait") ){
			//Wait
			tempCommand = new Wait(str[1], originalString);
			
		}
		else if(str[0].equals("set") && str[2].equals("state") ){
			//SetStateTest
			tempCommand = new SetStateTest(str[1],str[4],str[7],str[9], originalString);
			
		}
		
		
//Exception		
		else {
			throw new RuntimeException("Please enter correct command");
		}
		
		
		
		return tempCommand;
		
	}//end evaluate()


}
