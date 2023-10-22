// GUI libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Random;

// credit to macheads101 (https://www.youtube.com/watch?v=p9Y-NBg8eto) for the basics on how to move graphics with arrow keys

public class MoveSnake extends JPanel implements ActionListener, KeyListener {
    
    Timer t = new Timer(5, this);
    Graphics wall;
    static int WIDTH = 800, HEIGHT = 800; // dimensions of game
    int x = WIDTH/4, y = HEIGHT/2, deltaX = 0, deltaY = 0;
    int pieceSize = 40; // dimension of the snake, apple, and wall blocks
    int appleX = new Random().nextInt(WIDTH - 2 * pieceSize); // initial random x-value of the apple block
    int appleY = new Random().nextInt(HEIGHT - 2 * pieceSize); // initial random y-value of the apple block
    int wallX = new Random().nextInt(WIDTH - 2 * pieceSize); // initial random x-value of the wall block
    int wallY = new Random().nextInt(HEIGHT - 2 * pieceSize); // initial random y-value of the wall block
    boolean capturedApple = false; // intital boolean variable that represents if the snake touches an apple
    int count = 0; // counter for the amount of points the player scores
    static JFrame f;
    
    public MoveSnake() { // creates a snake that can be moved with the arrow keys
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    
    public void paintComponent(Graphics g) {
        Graphics apple = (Graphics2D) g; // creates a graphic object for the apple
        wall = (Graphics2D) g; // creates a graphic object for the wall
        
        super.paintComponent(apple);
        super.paintComponent(wall);
        super.paintComponent(g);
        
        // places and fills in the color of the snake block
        g.setColor(Color.BLACK);
        g.fillRect(x, y, pieceSize, pieceSize);
        
        // places and fills in the color of the initial apple block
        apple.setColor(Color.RED);
        apple.fillRect(appleX, appleY, pieceSize, pieceSize);
        
        // places and fills in the color of the initial wall block
        wall.setColor(Color.BLUE);
        wall.fillRect(wallX, wallY, pieceSize, pieceSize);
        
        if (capturedApple == true) { // if an apple has been captured ...
            count++; // ... the point total is incremented to signify the capturing of an apple
            
            if (count == 15) {
                System.out.println("Congratulations!");  
                System.out.println("You scored " + count + " points and won the game!"); 
                System.out.println("-------------------------------------"); 
                this.setVisible(false); 
                t.stop();
            }
            
            pieceSize += 3; // the dimensions of every block piece are scaled by 3 each time
            
            // the position for a new apple block is randomly generated and filled in 
            appleX = new Random().nextInt(WIDTH - 2 * pieceSize);
            appleY = new Random().nextInt(HEIGHT - 2 * pieceSize);
            apple.fillRect(appleX, appleY, pieceSize, pieceSize);
            
            generateWallBlock();
            
            capturedApple = false; // "capturedApple is reset to false"
        }
        setBackground(Color.GREEN); // sets the background of the GUI to green
    }
    
    public void actionPerformed(ActionEvent e) {
        repaint();
        x += deltaX;
        y += deltaY;
        
        // if any part of the snake block touches a red apple block, then the boolean variable "temp" is set to the opposite value
        if ((x + pieceSize > appleX && x - pieceSize < appleX) && (y + pieceSize > appleY && y - pieceSize < appleY)) {
            capturedApple = !(capturedApple);
        }
        
        // if any part of the snake block touches/intersects the wall block, the game quits and the final point score is shown
        if ((x + pieceSize > wallX && x - pieceSize < wallX) && (y + pieceSize > wallY && y - pieceSize < wallY)) {
            System.out.println("Game Over! You Hit a Wall!");  
            System.out.println("(keep in mind that a wall may have spawned in your position)");
            System.out.println("You Scored " + count + " Point(s)!"); 
            System.out.println("-------------------------------------"); 
            this.setVisible(false); 
            t.stop();
        }
        
        // if the snake goes out of bounds of the JFrame, the game quits and the final point score is shown
        if (x >= WIDTH || x <= 0 || y >= HEIGHT || y <= 0) { 
            System.out.println("Game Over! You Went Out of Bounds!");  
            System.out.println("You Scored " + count + " Point(s)!"); 
            System.out.println("-------------------------------------"); 
            this.setVisible(false); 
            t.stop();
        }
 
    }
    
    public void right() { // when called, will move the x-position of the snake to the right
        deltaX = 1;
        deltaY = 0;
        
        generateWallBlock();
    } 
    
    public void left() { // when called, will move the x-position of the snake to the left
        deltaX = -1;
        deltaY = 0;
        
        generateWallBlock();
    }
    
    public void up() { // when called, will move the y-position of the snake to the top
        deltaX = 0;
        deltaY = -1;
        
        generateWallBlock();
    }
    
    public void down() { // when called, will move the y-position of the snake to the bottom
        deltaX = 0;
        deltaY = 1;
        
        generateWallBlock();
    }
    
    public void generateWallBlock() {
        wallX = new Random().nextInt(WIDTH - 2 * pieceSize);
        wallY = new Random().nextInt(HEIGHT - 2 * pieceSize);
        
        // the position for a new wall block is randomly generated, and then 
        // checked to ensure it does not overlap with the apple block or snake block
        while ((wallX < appleX + (pieceSize * 2) && wallX > appleX - (pieceSize * 2)) && (wallX < x + (pieceSize * 2) && wallX > x - (pieceSize * 2))) {
            wallX = new Random().nextInt(WIDTH - 2 * pieceSize);
            wallY = new Random().nextInt(HEIGHT - 2 * pieceSize);
            wall.fillRect(wallX, wallY, pieceSize, pieceSize);
        }
    }
    
    public void keyPressed(KeyEvent e) { // depending on which arrow key is pressed, the appropriate function will be called to change the direction of the snake
        int code = e.getKeyCode();
        
        if (code == KeyEvent.VK_RIGHT)
            right();  
        if (code == KeyEvent.VK_LEFT)
            left();     
        if (code == KeyEvent.VK_UP)
            up();
        if (code == KeyEvent.VK_DOWN)
            down();
    }
    
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    
    public static void main(String args[]) {
        f = new JFrame(); // creates a new JFrame object
        MoveSnake s = new MoveSnake();
        f.add(s); // adds a snake block to the JFrame
        f.setVisible(true); // allows user to see GUI
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // program will exit out of JFrame when it is closed
        f.setSize(WIDTH, HEIGHT); // dimensions of the JFrame are set to certain values
        f.setResizable(false); // JFrame cannot be resized by user
        
        // the following code adds a label to the top of the GUI that provides brief instructions
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel textLabel  = new JLabel("Snake Game: Collect 15 Red Apples to Win the Game, and Avoid the Bouncing Blue Walls and Going Out of Bounds");
        JPanel textPanel = new JPanel(new FlowLayout());
        textPanel.add(textLabel);
        f.add(textPanel, BorderLayout.NORTH);
        
    }
}