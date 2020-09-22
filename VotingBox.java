import stanford.karel.*;



/*

- The world consists of a single row of ballot rectangles that appear on every even
intersection, as shown in the sample world. The size of the ballot, however, may be
different from the one shown in the example in the sense that it may contain any
number of ballot rectangles. In any case, the card will begin one square to the left of
the first rectangle and end one square to the right of the last rectangle.
*-From this you could infer you would need a while loop since there is no set parameters to use a for loop
-Every ballot rectangle is exactly one space wide and three spaces high, as shown in the
diagram.
*-setting the standard for movement and checking process 
- Karel always begins immediately to the left of the first ballot rectangle, facing the hole
that gives Karel access to the voting area along the center line of the rectangles.
- Karel must finish execution facing east at the rightmost edge of the ballot.

Decomposition and Psuedo code

Move Karel from left of all voting rectangles through them to check their vote ending on the right facing east 

Every voting rectangle is seperated by one ave step check check step step check check step step check check 
until blocked 

move 
*/




public class VotingBox extends SuperKarel{

	public void run() {
// this will move Karel into the correct starting location in the first voting rect. 
			intoPosition();
// check step step check step step etc using a while loop to repeat for unknown amount of time 
		while (frontIsClear()) {
			checkThrough();
			moveToNextOrStop();
		}
	}
	
	private void intoPosition() {
		turnLeft();
		move();
		move();
		turnRight();
		move();
	}
// will always be in first rectangle ready to count it 
	
	private void checkThrough() {
		
		if(beepersPresent() && facingEast() ) {
			moveToNextOrStop();
		}
// if a beeper is present it will move to next rectangle
		if(noBeepersPresent()) {
			turnLeft();
			move();
//check for beeper if none turn north and pick beeper up 
			while (beepersPresent()) {
				pickBeeper(); 
//not needed 
//					if(noBeepersPresent() && facingNorth() ) { 
//							turnAround();
//					}
				}
				
		}
		
		turnAround();
//Now is facing down 
		move();
		move();
// on bottom beeper 
		while (beepersPresent()) {
			pickBeeper();
//NOT NEEDED
//				if(noBeepersPresent() && facingSouth() ) { 
//						turnAround();
//				}
			}
// is not ready and in position for next rectangle 
		turnAround();
		move();
		turnRight();	
	}		
	
	private void moveToNextOrStop() {
			if(frontIsClear()) {
				move();
				if(frontIsClear()) {
					move();
				}
				if (frontIsBlocked()) {
					turnAround();
					turnAround();
					turnAround();
					turnAround();
//celebratory spin of joy indicating all votes have been corrected!!!!!!
				}
			}
		}
	
}
