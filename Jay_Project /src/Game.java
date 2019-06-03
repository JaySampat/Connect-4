import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.*;


public class Game extends BasicGame {
    Image board ;
    Image rPiece;
    Image yPiece;
    Image difficultyScreen;
    Image difficultyScreenvar;
    Image youWin;
    Image youLose;
    Image overlay;
    Image titleCard;
    Image restart;
    Image restartvar;
    Spot[][] spots;
    int [] height;
    boolean redTurn;
    boolean done;
    boolean difficulty;
    boolean titlecard;
    int difficultyLevel;

    public Game(String gamename) { super(gamename); }

    @Override
    public void init(GameContainer gc) throws SlickException {
        done = false;
        board = new Image("media/board.png");
        rPiece = new Image ("media/rPiece.png");
        yPiece = new Image ("media/yPiece.png");
        difficultyScreen = new Image ("media/difficultyScreen.png");
        youWin = new Image ("media/youWin.png");
        youLose = new Image ("media/youLose.png");
        titleCard = new Image ("media/titleCard.png");
        restart = new Image("media/restart.png");
        spots = new Spot [7][6];
        height = new int [7];
        redTurn = true;
        difficulty = true;
        titlecard = true;
        difficultyLevel = 0;
        for(int i = 0; i < 7; i++ ){
            height [i] = 5;
        }
        int x = 5;
        int y= 43;
        int dx = 60;
        int dy = 53;
        for(int n = 0; n < 7; n++){
            for(int m = 0; m < 6; m++ ){
                spots [n][m] = new Spot(x + dx * n, y + dy * m);
            }
        }



    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {

        if (gc.getInput().isKeyPressed(Input.KEY_R)) reset();

        if (redTurn) {
            if (gc.getInput().isKeyPressed(Input.KEY_1) && height[0] >= 0 && !done) {
                spots[0][height[0]].setImage(rPiece);
                redTurn = false;
                height[0]--;
            } else if (gc.getInput().isKeyPressed(Input.KEY_2) && height[1] >= 0 && !done) {
                spots[1][height[1]].setImage(rPiece);
                redTurn = false;
                height[1]--;
            } else if (gc.getInput().isKeyPressed(Input.KEY_3) && height[2] >= 0 && !done) {
                spots[2][height[2]].setImage(rPiece);
                redTurn = false;
                height[2]--;
            } else if (gc.getInput().isKeyPressed(Input.KEY_4)  && height[3] >= 0 && !done) {
                spots[3][height[3]].setImage(rPiece);
                redTurn = false;
                height[3]--;
            } else if (gc.getInput().isKeyPressed(Input.KEY_5) && height[4] >= 0 && !done) {
                spots[4][height[4]].setImage(rPiece);
                redTurn = false;
                height[4]--;
            } else if (gc.getInput().isKeyPressed(Input.KEY_6) && height[5] >= 0 && !done) {
                spots[5][height[5]].setImage(rPiece);
                redTurn = false;
                height[5]--;
            } else if (gc.getInput().isKeyPressed(Input.KEY_7) && height[6] >= 0 && !done) {
                spots[6][height[6]].setImage(rPiece);
                redTurn = false;
                height[6]--;
            }

        }
        if (!redTurn && difficultyLevel == 0) {
            if (gc.getInput().isKeyPressed(Input.KEY_1) && height[0] >= 0 && !done) {
                spots[0][height[0]].setImage(yPiece);
                redTurn = true;
                height[0]--;
            } else if (gc.getInput().isKeyPressed(Input.KEY_2) && height[1] >= 0 && !done) {
                spots[1][height[1]].setImage(yPiece);
                redTurn = true;
                height[1]--;
            } else if (gc.getInput().isKeyPressed(Input.KEY_3) && height[2] >= 0 && !done) {
                spots[2][height[2]].setImage(yPiece);
                redTurn = true;
                height[2]--;
            } else if (gc.getInput().isKeyPressed(Input.KEY_4)  && height[3] >= 0 && !done) {
                spots[3][height[3]].setImage(yPiece);
                redTurn = true;
                height[3]--;
            } else if (gc.getInput().isKeyPressed(Input.KEY_5) && height[4] >= 0 && !done) {
                spots[4][height[4]].setImage(yPiece);
                redTurn = true;
                height[4]--;
            } else if (gc.getInput().isKeyPressed(Input.KEY_6) && height[5] >= 0 && !done) {
                spots[5][height[5]].setImage(yPiece);
                redTurn = true;
                height[5]--;
            } else if (gc.getInput().isKeyPressed(Input.KEY_7) && height[6] >= 0 && !done) {
                spots[6][height[6]].setImage(yPiece);
                redTurn = true;
                height[6]--;
            }

        }
        if(difficulty){
            if (gc.getInput().isKeyPressed(Input.KEY_A)) {
                difficultyLevel = 1;
                difficulty = false;
            }
            else if (gc.getInput().isKeyPressed(Input.KEY_B)) {
                difficultyLevel = 2;
                difficulty = false;
            }
            else if (gc.getInput().isKeyPressed(Input.KEY_C)) {
                difficultyLevel = 3;
                difficulty = false;
            }
            else if (gc.getInput().isKeyPressed(Input.KEY_D)) {
                difficultyLevel = 0;
                difficulty = false;

            }else if (gc.getInput().isKeyPressed(Input.KEY_SPACE)){
                titlecard = false;
            }


        }


        if(isWin()== 1){
            //System.out.println("Red Win");
            drawSpots();
            //board = youWin;
            //board.draw(-150,-50, 1f);
            done = true;
        }
        else if(isWin() == 2){
            //System.out.println("Yellow Win");
            //board = youLose;
            //board.draw(-150,-50, 1f);
            drawSpots();
            done = true;
        }

    }


    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        if (difficulty == true){
            restartvar = null;

            if (titlecard == true){
                difficultyScreenvar = titleCard;
                difficultyScreenvar.draw(-45, 0, 1.0f);
            }
            else{
                difficultyScreenvar = difficultyScreen;
                difficultyScreenvar.draw(-35, -5, 1.0f);

            }
        }



        else{
            difficultyScreenvar = null;
            restartvar = restart;
            restartvar.draw(155, 10, 0.5f);
            board.draw(-150,-50 ,0.1f);
            drawSpots();
            if(difficultyLevel > 0){
                computerPlayer();
            }
            else{

            }
        }
        if (difficultyLevel > 0 && isWin() == 1){
            overlay = youWin;
            overlay.draw(10,-10, 0.7f);
        }
        else if (difficultyLevel > 0 && isWin() == 2){
            overlay = youLose;
            overlay.draw(-20,-20, 0.2f);
        }


    }


    private int isWin(){
        for(int n = 0; n < 7; n++){  // check vertical
            int rCount = 0;
            int yCount = 0;
            for(int m = 0; m < 6; m++){
                if(spots[n][m].getImage() == rPiece){
                    rCount++;
                    yCount = 0;

                } else if(spots[n][m].getImage() == yPiece) {
                    yCount++;
                    rCount = 0;
                } else {
                    rCount = 0;
                    yCount = 0;
                }
                if (rCount == 4) return 1;
                else if(yCount == 4) return 2;
            }
        }

        for(int n = 0; n < 6; n++){
            int rCount = 0;
            int yCount = 0;
            for(int m = 0; m < 7; m++){  // check horizontal
                if(spots[m][n].getImage() == rPiece){
                    rCount++;
                    yCount = 0;
                } else if(spots[m][n].getImage() == yPiece){
                    yCount++;
                    rCount = 0;
                } else {
                    rCount = 0;
                    yCount = 0;
                }
                if (rCount == 4) return 1;
                else if(yCount == 4) return 2;
            }
        }

        for (int n = 0; n < 4; n++) {  // check m = -1
            for (int m = 0; m < 3; m++) {
                int rCount = 0;
                int yCount = 0;
                if (spots[n][m].getImage() == rPiece) {
                    rCount++;
                    for (int i = 1; i < 4; i ++) {
                        if (spots[n + i][m + i].getImage() == rPiece ) {
                            rCount ++;
                        }
                    }
                } else if (spots[n][m].getImage() == yPiece) {
                    yCount++;
                    for (int i = 1; i < 4; i ++) {
                        if (spots[n + i][m + i].getImage() == yPiece ) {
                            yCount ++;
                        }
                    }
                } else {
                    rCount = 0;
                    yCount = 0;
                }
                if (rCount == 4) return 1;
                else if(yCount == 4) return 2;
            }
        }

        for (int n = 0; n < 4; n++) {  // check m = 1
            for (int m = 3; m < 6; m++) {
                int rCount = 0;
                int yCount = 0;
                if (spots[n][m].getImage() == rPiece) {
                    rCount++;
                    for (int i = 1; i < 4; i ++) {
                        if (spots[n + i][m - i].getImage() == rPiece ) {
                            rCount ++;
                        }
                    }
                } else if (spots[n][m].getImage() == yPiece) {
                    yCount++;
                    for (int i = 1; i < 4; i ++) {
                        if (spots[n + i][m - i].getImage() == yPiece ) {
                            yCount ++;
                        }
                    }
                } else {
                    rCount = 0;
                    yCount = 0;
                }
                if (rCount == 4) return 1;
                else if(yCount == 4) return 2;
            }
        }


        return 0;
    }
    private void reset(){
        for(int n = 0; n < 7; n++){
            for(int m = 0; m < 6; m++ ){
                spots [n][m].setImage(null);
            }
        }
        for(int i = 0; i < 7; i++ ){
            height [i] = 5;
        }
        redTurn = true;
        done = false;
        difficulty = true;
    }

    private void drawSpots(){
        for(int n = 0; n < 7; n++){
            for(int m = 0; m < 6; m++){
                if(spots[n][m].getImage() != null ){
                    spots[n][m].getImage().draw(spots[n][m].getX(), spots[n][m].getY(), spots [n][m].getScale());
                }
            }
        }
    }

    private void computerPlayer(){
        if(!redTurn && !done){
            int vWin = verticalPossibleWin();
            int hWin = horizontalPossibleWin();
            int vBlock = verticalPossibleBlock();
            int hBlock = horizontalPossibleBlock();
            int dBlock = diagonalBlock();
            int vMove = verticalMove();
            int hMove = horizontalMove();
            //System.out.println("vBlock: " + vBlock);
            //System.out.println(hWin);
            Random rand = new Random();
            int n = rand.nextInt(7) + 1;

            if( vBlock != -1 && height[vBlock] >= 0 && difficultyLevel > 1){


                spots[vBlock][height[vBlock]].setImage(yPiece);
                height[vBlock]--;

                redTurn = true;
            }
            else if( hBlock != -1 && height[hBlock] >= 0 && difficultyLevel > 1){


                spots[hBlock][height[hBlock]].setImage(yPiece);
                height[hBlock]--;

                redTurn = true;
            }
            else if( dBlock != -1 && height[dBlock] >= 0 && difficultyLevel > 2){


                spots[dBlock][height[dBlock]].setImage(yPiece);
                height[dBlock]--;

                redTurn = true;
            }
           else  if( hWin != -1 && height[hWin] >= 0 && difficultyLevel > 2){


                spots[hWin][height[hWin]].setImage(yPiece);
                height[hWin]--;

                redTurn = true;
            }
            else if( vWin != -1 && height[vWin] >= 0 && difficultyLevel > 2){


                spots[vWin][height[vWin]].setImage(yPiece);
                height[vWin]--;

                redTurn = true;
            }
            else if (vMove != -1 && height[vMove] >= 0 && difficultyLevel > 1){
                spots[vMove][height[vMove]].setImage(yPiece);
                height[vMove]--;

                redTurn = true;
            }
            else if (hMove != -1 && height[hMove] >= 0){
                spots[hMove][height[hMove]].setImage(yPiece);
                height[hMove]--;

                redTurn = true;
            }
            else if(n == 1 && height[0] >= 0){

                spots[0][height[0]].setImage(yPiece);
                redTurn = true;


                height[0]--;
            }
            else if(n == 2 && height[1] >= 0){

                spots[1][height[1]].setImage(yPiece);
                redTurn = true;


                height[1]--;
            }
            else if(n == 3 && height[2] >= 0){

                spots[2][height[2]].setImage(yPiece);
                redTurn = true;


                height[2]--;
            }
            else if(n == 4 && height[3] >= 0){

                spots[3][height[3]].setImage(yPiece);
                redTurn = true;


                height[3]--;
            }
            else if(n == 5 && height[4] >= 0){

                spots[4][height[4]].setImage(yPiece);
                redTurn = true;


                height[4]--;
            }
            else if(n == 6 && height[5] >= 0){

                spots[5][height[5]].setImage(yPiece);
                redTurn = true;


                height[5]--;
            }
            else if(n == 7 && height[6] >= 0){

                spots[6][height[6]].setImage(yPiece);
                redTurn = true;


                height[6]--;
            }

        }
    }
    private int verticalPossibleWin(){


        for(int n = 0; n < 7; n++){  // check vertical

            int yCount = 0;
            for(int m = 5; m >= 0; m--) {
                if (spots[n][m].getImage() == yPiece) {
                    yCount++;
                }
                else if (spots[n][m].getImage() == rPiece) {
                    yCount = 0;

                }
                else if (yCount == 3 && spots[n][m].getImage() == null){
                    return n;

                }



            }
        }
        return -1;
    }
    private int verticalMove(){


        for(int n = 0; n < 7; n++){  // check vertical

            int yCount = 0;
            for(int m = 5; m >= 0; m--) {
                if (spots[n][m].getImage() == yPiece) {
                    yCount++;
                }
                else if (spots[n][m].getImage() == rPiece) {
                    yCount = 0;

                }
                else if (yCount == 2 && spots[n][m].getImage() == null){
                    return n;

                }


            }
        }
        return -1;
    }

    private int horizontalPossibleWin(){
        int yCount = 0;
        int currentHeight = height[0];
        if(height[0] < 5 && spots[0][height[0]+ 1].getImage() == yPiece){
            yCount++;
        }

        for(int n = 1; n < 7; n++){

            if (height[n] < 5 && spots[n][height[n]+ 1].getImage() == yPiece && height[n] == currentHeight){
                yCount++;

            }
            else if(yCount == 3 && height[n] == currentHeight && spots[n][height[n]].getImage() == null){
                return n;
            }

            else{
                yCount = 0;
            }
            currentHeight = height[n];

        }


        for(int n = 6; n >= 0; n--){
            if (height[n] < 5 && spots[n][height[n] + 1].getImage() == yPiece && height[n] == currentHeight){
                yCount++;
            }
            else if(yCount == 3 && height[n] == currentHeight && spots[n][height[n]].getImage() == null){
                return n;
            }

            else{
                yCount = 0;
            }
            currentHeight = height[n];

        }
        return -1;
    }
    private int horizontalMove(){
        int yCount = 0;
        int currentHeight = height[0];
        if(height[0] < 5 && spots[0][height[0]+ 1].getImage() == yPiece){
            yCount++;
        }

        for(int n = 1; n < 7; n++){

            if (height[n] < 5 && spots[n][height[n]+ 1].getImage() == yPiece && height[n] == currentHeight){
                yCount++;

            }
            else if(yCount == 2 && height[n] == currentHeight && spots[n][height[n]].getImage() == null){
                return n;
            }

            else{
                yCount = 0;
            }
            currentHeight = height[n];

        }


        for(int n = 6; n >= 0; n--){
            if (height[n] < 5 && spots[n][height[n] + 1].getImage() == yPiece && height[n] == currentHeight){
                yCount++;
            }
            else if(yCount == 2 && height[n] == currentHeight && spots[n][height[n]].getImage() == null){
                return n;
            }

            else{
                yCount = 0;
            }
            currentHeight = height[n];

        }
        return -1;
    }



    private int verticalPossibleBlock(){

        for(int n = 0; n < 7; n++){  // check vertical

            int rCount = 0;
            for(int m = 5; m >= 0; m--) {
                if (spots[n][m].getImage() == rPiece) {
                    rCount++;
                }
                else if (spots[n][m].getImage() == yPiece) {
                    rCount = 0;

                }
                else if (rCount == 3 && spots[n][m].getImage() == null){
                    return n;

                }

            }
        }
        return -1;
    }
    private int horizontalPossibleBlock(){
        int rCount = 0;
        int previousEmpty = -1;



        for(int m = 0; m < 6; m++){
            for(int n = 0; n < 7; n++) {


                if (spots[n][m].getImage() == rPiece) {
                    rCount++;

                } else if (spots[n][m].getImage() == null && rCount > 0 && previousEmpty == -1) {
                    previousEmpty = n;

                } else if (rCount == 3 && spots[n][height[n]].getImage() == null) {
                    if (previousEmpty != -1) {
                        return previousEmpty;
                    }
                    return n;
                }

            }
                rCount = 0;
                previousEmpty = -1;
        }
        for(int m = 0; m < 6; m++){
            for(int n = 6; n >= 0; n--) {


                if (spots[n][m].getImage() == rPiece) {
                    rCount++;

                } else if (spots[n][m].getImage() == null && rCount > 0 && previousEmpty == -1) {
                    previousEmpty = n;

                } else if (rCount == 3 && spots[n][height[n]].getImage() == null) {
                    if (previousEmpty != -1) {
                        return previousEmpty;
                    }
                    return n;
                }

            }
            rCount = 0;
            previousEmpty = -1;
        }


        return -1;
    }

    private int diagonalBlock(){
        int rCount = 0;
        for(int n = 0; n < 6; n++){
            int x = 0;
            int y = n;
            while(x < 7 && y < 6){
                if(spots[x][y].getImage() == null && (y == 5 || spots[x][y].getImage() != null) && rCount == 3 ){
                    return x;
                }
                if(spots[x][y].getImage() == rPiece){
                    rCount++;


                }

                else {
                    rCount = 0;
                }

                x++;
                y++;
            }
        }
        for(int n = 5; n >= 0 ; n--){
            int x = 0;
            int y = n;
            while(x < 7 && y >= 0){
                if(spots[x][y].getImage() == null && rCount == 3 ){
                    return x;
                }
                if(spots[x][y].getImage() == rPiece){
                    rCount++;


                }

                else {
                    rCount = 0;
                }

                x++;
                y--;
            }
        }
        for(int n = 0; n < 7; n++){
            int x = n;
            int y = 0;
            while(x < 7 && y < 6){
                if(spots[x][y].getImage() == null && rCount == 3 ){
                    return x;
                }
                if(spots[x][y].getImage() == rPiece){
                    rCount++;

                }

                else {
                    rCount = 0;
                }

                x++;
                y++;
            }
        }
        for(int n = 6; n >= 0; n--){
            int x = n;
            int y = 0;
            while(x > 0 && y < 6){
                if(spots[x][y].getImage() == null && rCount == 3 ){
                    return x;
                }
                if(spots[x][y].getImage() == rPiece){
                    rCount++;
                    //System.out.println("rCount: " + rCount);
                    //System.out.println("x: " + x);
                    //System.out.println("y: " + y);
                }

                else {
                    rCount = 0;
                }

                x--;
                y++;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        try {
            AppGameContainer appgc = new AppGameContainer(new Game("Connect Four"));
            appgc.setShowFPS(false);
            appgc.setDisplayMode(500, 500, false);
            appgc.start();
        } catch (SlickException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}