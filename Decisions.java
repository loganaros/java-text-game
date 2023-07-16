import java.util.Scanner;

public class Decisions {

	int wakeTime,dotw,offWake,aTime;
	
	boolean grabID,needRide,goSchool,happy,bathroom,breakfast,ready,friendOver = false,busted,late = false,easterEgg,sleepIn,afterBath;
	
	String morningTalk,returnBathroom,eveningActivity,Dayotw,person,activity,food,social;
	
	//checked
	public void morning() throws InterruptedException {
		Scanner morn = new Scanner(System.in);
		System.out.println("                 Logan's Day\n");
		System.out.println("Please enter all information when requested, and \ntimes in the form of military time(Ex:600, 1345, etc.)\n(630 corresponds to 6:30)");
		System.out.println("Please input which day of the week it is?");
		System.out.print("Input(1-7): ");
		dotw = morn.nextInt();
		if (dotw == 1) {
			goSchool = false;
			Dayotw = "Sunday";
			this.notSchool();
		} else if (dotw == 2) {
			Dayotw = "Monday";
		} else if (dotw == 3) {
			Dayotw = "Tuesday";
		} else if (dotw == 4) {
			Dayotw = "Wednesday";
		} else if (dotw == 5) {
			Dayotw = "Thursday";
		} else if (dotw == 6) {
			Dayotw = "Friday";
		} else if (dotw == 7) {
			goSchool = false;
			Dayotw = "Saturday";
			this.notSchool();
		} else {
			System.out.println("Invalid day.");
			Thread.sleep(1000);
			this.morning();
		}
		System.out.println("Also, it is morning, what time do you decide to wake up?");
		System.out.print("Input: ");
		wakeTime = morn.nextInt();
			
		if (dotw >= 2 && dotw <= 6) {
			if (wakeTime < 600) {
				System.out.println("It's still early, you can sleep in a little.\nFast forwarding to 605...");
				Thread.sleep(2000);
				wakeTime = 605;
			} 
				
			if (wakeTime >= 600 && wakeTime <= 610) {
				System.out.println("It's time to get up now, and you still have time to go\nto the bathroom, would you like to?[y/n]");
				System.out.print("Input: ");
				String yorn = morn.next();
				if (yorn.equals("y")) {
					System.out.println("You go to bathroom until 6:20, and now you have to get ready.");
					bathroom = true;
					breakfast = true;
					ready = true;
					grabID = true;
					goSchool = true;
					Thread.sleep(2000);
					this.school();
				} else if (yorn.equals("n")) {
					System.out.println("You decide not to go the bathroom since there are more important matters to attend to");
					Thread.sleep(2000);
					System.out.println("Now it's time to head to school, after you've gotten ready and eaten breakfast of course");
					bathroom = false;
					breakfast = true;
					ready = true;
					grabID = true;
					goSchool = true;
					Thread.sleep(2000);
					this.school();
				} else {
					System.out.println("Invalid input.");
					Thread.sleep(1000);
					this.morning();
				}
			} else if (wakeTime >= 620 && wakeTime <= 635) {
				System.out.println("You don't have time to go to the bathroom now, but you can still eat breakfast quickly.");
				bathroom = false;
				breakfast = true;
				ready = true;
				grabID = true;
				goSchool = true;
				Thread.sleep(2000);
				this.school();
			} else if (wakeTime >= 635 && wakeTime <= 650) {
				System.out.println("You can still make it to school, but there isn't\ntime to get ready now or eat breakfast.");
				bathroom = false;
				breakfast = false;
				ready = false;
				grabID = false;
				goSchool = true;
				Thread.sleep(2000);
				this.school();
			} else if (wakeTime >= 650 && wakeTime <= 715) {
				System.out.println("You can still make it, but you will need a ride.");
				if (dotw == 2 || dotw == 4 || dotw == 6) {
					System.out.println("Since it is " + Dayotw + ", your mother is already at work, so\nyou will not be able to go to school today(sadly, I know).");
					Thread.sleep(3500);
					this.notSchool();
				} else if (dotw == 3 || dotw == 5) {
					System.out.println("Your mother is home but isn't awake.");
					Thread.sleep(2000);
					System.out.println("You can wake her up and make her take you to school or you can\njust not go today, which would you like to do?[go/stay]");
					String gors = morn.next();
					if (gors.equals("go")) {
						bathroom = false;
						breakfast = false;
						ready = true;
						grabID = false;
						goSchool = true;
						late = true;
						Thread.sleep(2000);
						this.school();
					} else if (gors.equals("stay")) {
						this.notSchool();
					} else {
						System.out.println("Invalid answer");
						this.morning();
					}
				}
				Thread.sleep(2000);
				this.evening();		
			} else if (wakeTime >= 720) {
				System.out.println("You woke up late, and now you just have to stay home");
				goSchool = false;
				Thread.sleep(2000);
				this.notSchool();
			} else {
				System.out.println("Invalid time.");
				this.morning();
			}
			
			if (goSchool == true) {
				this.school();
			} else {
				this.notSchool();
			}
		} else if (dotw == 1 || dotw == 7){
			this.notSchool();
		} else {
			System.out.println("Invalid answer.");
			Thread.sleep(2000);
			this.morning();
		}
	}
	//checked
	public void school() throws InterruptedException {
		Scanner schoolio = new Scanner(System.in);
		System.out.println("Congragulations, you made it to school!");
		Thread.sleep(2000);
		System.out.println("You arrive at school and wait for it to start.");
		if (ready == false) {
			System.out.println("You aren't ready, so do you talk to anybody in the morning?[y/n]");
			morningTalk = schoolio.next();
			if (morningTalk.equals("y")) {
				morningTalk = "yes";
				System.out.println("Ok, who would you like to talk to?");
				System.out.print("Input: ");
				person = schoolio.next();
				if (person.equals("Jeff") || person.equals("Isaac") || person.equals("only friend")) {
					System.out.print("Talking");
					Thread.sleep(1000);
					System.out.print(".");
					Thread.sleep(1000);
					System.out.print(".");
					Thread.sleep(1000);
					System.out.print(".");
					Thread.sleep(1000);
					System.out.println("You talked for a bit and had a great conversation, but now it's time to go to class");
					Thread.sleep(1000);
					System.out.println("The bell just rung, and " + person + " has invited you to ditch first period with them.");
					System.out.println("Do you?[y/n]");
					System.out.print("Input: ");
					String yorn = schoolio.next();
					if (yorn.equals("y")) {
						if (dotw == 2 || dotw == 4 || dotw == 6) {
							System.out.println("Since it is " + Dayotw + ", your mother is home but you take your chances\nand hang out for the rest of the day.");
							friendOver = false;
							Thread.sleep(5000);
							this.notSchool();
						} else {
							System.out.println("Since it is " + Dayotw + ", your mother isn't home and you will be able to\ngo to your house, and so you ditch for the day.");
							friendOver = true;
							Thread.sleep(5000);
							this.notSchool();
						}
					} else if (yorn.equals("n")) {
						friendOver = false;
						System.out.println("You decide to be a good student and stay for the day.");
						Thread.sleep(3000);
					} else {
						System.out.println("Invalid answer.");
						this.school();
					}
				} else {
					System.out.println("You go and talk to " + person);
					happy = true;
					Thread.sleep(1000);
					System.out.println("Except...");
				}
			} else if (morningTalk.equals("n")) {
				morningTalk = "no";
				System.out.println("Ok loner, let's just go to class then since the bell just rung.");
			} else {
				System.out.println("Invalid input.");
				Thread.sleep(1000);
				this.school();
			}
		} else {
			System.out.println("You seem ready for the day, so you go and talk to one of your friends.");
			morningTalk = "yes";
			happy = true;
		}//
		Thread.sleep(3000);
		System.out.println("\nIt's now 1st period, and you go to algebra");
		if (ready == true) {
			System.out.println("Since you were ready this morning, you remembered to grab all\nof your homework and you turn it in.");
			happy = true;
		} else {
			System.out.println("Since you weren't ready this morning, you forgot to grab your\nhomework and you get points docked off.");
			happy = false;
		}
		Thread.sleep(3000);
		System.out.println("\nIt is now 2nd period, and you go to World History");
		if (grabID == true) {
			System.out.println("You were a good boy and remembered to put on your id before\nyou left today and your teacher smiles and shakes your hand");
			happy = true;
		} else if (grabID == true && ready == false){
			System.out.println("You weren't ready this morning, but you did manage to grab\nyour id before you left and your teacher welcomes you, but\nshe avoids you due to your bad breath");
			happy = true;
		} else {
			System.out.println("You have to get and ID now because you couldn't manage it\nthis morning due to not being ready");
			happy = false;
		}
		Thread.sleep(3000);
		System.out.println("\nIt is now 3rd period, time to go to biology");
		if (bathroom == true) {
			System.out.println("You managed to get up early enough to go to the bathroom\nthis morning, thus you can finish biology in peace");
			happy = true;
		} else {
			System.out.println("You didn't manage to go to the bathroom this morning, so\nyou have to go in the middle of class, and everyone looks at\nyou weird when you come back");
			happy = false;
		}
		Thread.sleep(3000);
		System.out.println("\nIt is now lunchtime");
		if (breakfast == true && ready == false) {
			System.out.println("You didn't grab your lunch this morning, good thing you got\nyour breakfast in as you won't be able to get lunch");
			happy = true;
		} else if (breakfast == false && ready == true) {
			System.out.println("You didn't manage to eat breakfast this morning, good thing\nyou were ready and got your breakfast, because you are STARVING");
			happy = true;
		} else if (breakfast == true && ready == true) {
			System.out.println("You both ate your breakfast this morning AND were ready and\ngot your lunch, you are double happy for being on your game today!");
			happy = true;
		} else {
			System.out.println("Sadly, you couldn't grab breakfast or your lunch this morning,\nso you are sad and hungry :(");
			happy = false;
		}
		Thread.sleep(3000);
		System.out.println("\nIt is now 5th period, time for game design");
		if (happy == true) {
			System.out.println("You get to Mr.Bernard's classroom, and since you are happy,\nyou have a very productive day and a lot of fun in class");
		} else {
			System.out.println("You get to Mr.Bernard's class, and since you are unhappy,\nyou don't get much work done and hope for the day to end quick");
		}
		Thread.sleep(3000);
		System.out.println("\nIt is now time to go home");
		Thread.sleep(1000);
		this.evening();
	}
	//checked
	public void notSchool() throws InterruptedException {
		Scanner not = new Scanner(System.in);
		System.out.println("Congrats, man. You got the day off!");
		Thread.sleep(2000);
		if (dotw == 1 || dotw == 7) {
			System.out.println("It is the weekend, and you have the whole day to yourself!");
			Thread.sleep(2000);
			System.out.println("Isn't that exciting?(Or scary)");
			Thread.sleep(1000);
			System.out.println("You can either play on your computer or stay in bed for a bit?\n[1/2]");
			System.out.print("Input: ");
			int one = not.nextInt();
			if (one == 1) {
				activity = "play on pc";
				System.out.println("You chose to get up and start playing on your PC for a bit");
				Thread.sleep(2000);
				System.out.println("After having a ton of fun playing with your friend, you glance at the clock");
				Thread.sleep(1000);
				System.out.println("'4:00'");
				Thread.sleep(1000);
				System.out.println("You played all day...");
				System.out.println("And now its the evening time");
				happy = false;
				Thread.sleep(2000);
				this.evening();
			} else if (one == 2) {
				activity = "bed";
				System.out.println("You chose to stay in bed for a while, what time would you like to wake up?");
				System.out.print("Input: ");
				offWake = not.nextInt();
				wakeTime = offWake;
				if (offWake < 1000) {
					sleepIn = false;
					String oWake = Integer.toString(offWake);
					String first = oWake.substring(0, 1);
					String last = oWake.substring(1);
					System.out.println("You woke up at " + first + ":" + last + ", and you sleep in until 10:00");
					Thread.sleep(1000);
					System.out.println("It is now lunchtime, do you want PB&J or Pizza?[1/2]");
					System.out.print("Input: ");
					int or2 = not.nextInt();
					if (or2 == 1) {
						food = "PB&J";
						System.out.println("You chose to eat PB&J");
						Thread.sleep(1000);
						System.out.println("What? You want a prize or something? Move on");
						Thread.sleep(2000);
					} else if (or2 == 2) {
						food = "pizza";
						System.out.println("You chose to eat pizza\n");
						Thread.sleep(1000);
						System.out.print("What? Oh yeah, since you got pizza, you are sick until night, fast forwarding to evening");
						happy = false;
						Thread.sleep(1000);
						System.out.print(".");
						Thread.sleep(1000);
						System.out.print(".");
						Thread.sleep(1000);
						System.out.print(".");
						this.evening();
					} else {
						System.out.println("Invalid input.");
						Thread.sleep(1000);
						this.notSchool();
					}
				} else {
					sleepIn = true;
					System.out.println("You slept in and now you are well rested, but good luck going to sleep tonight...");
					Thread.sleep(2000);
					System.out.println("Fast forwarding to evening...");
					happy = true;
					Thread.sleep(2000);
					this.evening();
				}
			} else {
				System.out.println("Invalid input.");
				Thread.sleep(1000);
				this.notSchool();
			}
		} else {
			if (friendOver == false) {
				System.out.println("So you woke up, but when are you going to actually get out of bed?");
				offWake = not.nextInt();
				if (offWake <= 1000) {
					System.out.println("You've woke up in the morning, ");
					this.evening();
				}
			} else {
				System.out.println("You just got home, but is your mother home?");
				Thread.sleep(3000);
				if (dotw == 2 || dotw == 4 || dotw == 6) {
					System.out.println("It looks like she is! Busted!\n");
					busted = true;
					Thread.sleep(2000);
					System.out.print("You are now going to be grounded until night time, fast forwarding\n");
					Thread.sleep(1000);
					System.out.print(".");
					Thread.sleep(1000);
					System.out.print(".");
					Thread.sleep(1000);
					System.out.print(".");
					Thread.sleep(1000);
					this.night();
				}	
			}
		} this.evening();
	}
	//checked
	public void evening() throws InterruptedException {
		Scanner even = new Scanner(System.in);
		Scanner even1 = new Scanner(System.in);
		if (goSchool == true) {
			System.out.println("It is now evening, after you have gotten home from school.");
			Thread.sleep(2000);
			System.out.println("You can go to the bathroom if you would like to?[y/n]");
			returnBathroom = even.next();
			if (returnBathroom.equals("y")) {
				System.out.println("You go the bathroom, and have a grand 'ole time");
				afterBath = true;
			} else if (returnBathroom.equals("n")) {
				System.out.println("Good, you have more time to play on your computer like a pleb");
				afterBath = false;
			} else if (returnBathroom.equals("3")) {
				System.out.println("Congragulations, you activated a hidden easter egg!");
				easterEgg = true;
				Thread.sleep(2000);
				System.out.println("Because of this, I will allow you a hint, do you want the hint?[y/n]");
				String yorn = even.next();
				if (yorn.equals("y")) {
					System.out.println("The hint is...");
					Thread.sleep(2000);
					for (int i = 0; i < 100; i++) {
						System.out.println("YOUR LIFE IS A LIE");
					}
				} else if (yorn.equals("n")) {
					System.out.println("Fine then...");
					happy = false;
				} else if (yorn.equals("3")) {
					System.out.println("cute.");
					happy = true;
				} else {
					System.out.println("Invalid response");
					this.evening();
				}
				happy = true;
			} else {
				System.out.println("Invalid answer.");
				this.evening();
			}
		} else {
			System.out.println("It is now evening, and the day is coming to an end.");
		}
		if (friendOver == true && goSchool == true) {
			System.out.println("Your friend left earlier, after hanging out all day");
		}
		Thread.sleep(2000);
		System.out.println("What would you like to do?");
		eveningActivity = even1.nextLine();
		System.out.println("So, you said you would like to " + eveningActivity + ", correct?");
		Thread.sleep(3000);
		System.out.println("GOOD.");
		System.out.println("You go and " + eveningActivity);
		this.night();
	}
	//checked	
	public void night() throws InterruptedException {
		Scanner nite = new Scanner(System.in);
		System.out.println("It is now night");
		Thread.sleep(1000);
		System.out.println("You go into your room and lay down.");
		Thread.sleep(1000);
		System.out.println("You can either go to bed now and get some sleep or you can stay on your phone for a bit");
		System.out.print("[1/2]Input: ");
		int one = nite.nextInt();
		if (one == 1) {
			social = "you didn't";
			System.out.println("You decide to go to bed early, since you are tired from the day.");
			aTime = 900;
			happy = true;
			Thread.sleep(3000);
		} else if (one == 2) {
			System.out.println("You decide to get on your phone for a bit, and see what new posts there are");
			Thread.sleep(2000);
			System.out.println("You can either go on Instagram or Snapchat[insta/snap]");
			System.out.print("Input: ");
			String insta = nite.next();
			if (insta.equals("insta")) {
				social = "Instagram";
				System.out.println("You decide to go on Instagram and look at a few memes before you eventually pass out");
				aTime = 1000;
				Thread.sleep(2000);
				this.recap();
			} else if (insta.equals("snap")) {
				social = "Snapchat";
				System.out.println("You decide to scroll through Snapchat and see what fun things your 'friends' are up to");
				Thread.sleep(2000);
				System.out.println("You get a text from someone, but you are pretty tired.\nDo you answer them or ignore them and go to sleep?[1/2]");
				int two = nite.nextInt();
				if (two == 1) {
					System.out.println("It's one of your good friends, so you talk to them for a bit\nand become much closer. After a while you say goodnight\nbecause you have to go to bed, but you do it with a smile on your face");
					aTime = 1200;
					happy = true;
					Thread.sleep(4000);
				} else if (two == 2) {
					System.out.println("You ignore them, which makes you sad.. You fall asleep though eventually");
					happy = false;
					aTime = 1000;
				} else {
					System.out.println("Invalid input.");
					Thread.sleep(1000);
					this.night();
				}
			} else {
				System.out.println("Invalid input.");
				Thread.sleep(1000);
				this.night();
			}
		} else {
			System.out.println("Invalid input.");
			Thread.sleep(1000);
			this.night();
		}
		this.recap();
	}
	//checked
	public void recap() throws InterruptedException {
		System.out.println("           Recap");
		System.out.println("You woke up at " + wakeTime + ".");
		System.out.println("You woke up on a " + Dayotw + ".");
		if (goSchool == true) {
			System.out.println("Went to bathroom: " + bathroom);
			System.out.println("Got breakfast: " + breakfast);
			System.out.println("Were ready: " + ready);
			System.out.println("Grabbed your ID: " + grabID);
			System.out.println("Went to school: " + goSchool);
			if (late == true) {
				System.out.println("Woke up late: " + late);
			}
			if (morningTalk.equals("yes")) {
				System.out.println("Talked to someone in the morning: " + morningTalk);
				if (person != null) {
					System.out.println("The person you talked to: " + person);
				}
				if (friendOver == true) {
					System.out.println("Had a friend over: " + friendOver);
					System.out.println("Friend's name: " + person);
				}
			}
		} else {
			if (late == true) {
				System.out.println("You woke up late and didn't manage to get to school");
			}
			System.out.println("In the morning, you chose to " + activity);
			System.out.println("Slept in: " + sleepIn);
			if (food != null) {
				System.out.println("You chose to eat " + food);
			}
		}
		System.out.println("Went to bathroom after school: " + afterBath);
		System.out.println("*Happy at end of day: " + happy + "*");
		System.out.println("Your evening activity was to: " + eveningActivity);
		if (easterEgg == true) {
			System.out.println("You found an easter egg...");
		}
		System.out.println("Social media on: " + social);
		System.out.println("You eventually fell asleep at: " + aTime);
		Thread.sleep(2000);
		System.out.println("It is now time for another day to start, so ready? In ");
		Thread.sleep(2000);
		System.out.print("3..");
		Thread.sleep(1000);
		System.out.print("2..");
		Thread.sleep(1000);
		System.out.print("1..\n");
		Thread.sleep(1000);
		this.morning();
	}
	//checked
	public static void main(String[] args) throws InterruptedException {
		new Decisions().morning();
	}
}
//needed an even line number :P