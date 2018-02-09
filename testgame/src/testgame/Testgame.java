package testgame;

import java.util.Random;
import java.util.Scanner;

class Mario2{
int y;//координаты по y
int x;//координаты по x
}

class Mario{
int r;//координаты по y
int c;//координаты по x
}

class Field{
    private int[][] matrix;
    private int h,w;
    Field(int h_,int w_){
         this.h=h_;
         this.w=w_;
    matrix=new int[h][w];
    init(30);
    };
    
    private void init(int prs){
      Random rand=new Random();  
      int randomNum;
      for (int i=0;i<h;i++){
          for (int j=0;j<w;j++){
             randomNum=rand.nextInt(105);
             if(randomNum>prs){
            matrix[i][j]=0;
             }else{
             matrix[i][j]=1;
             }                          
          }
          /*Месторасположение золота*/
          matrix[h-1][w-6]=8;
      }
    }
  
    public void showLocation(int r_,int c_,int x_,int y_){
     for (int i=0;i<h;i++){
          for(int j=0;j<w;j++){
              if ((i==r_) && (j==c_))
                  System.out.print("Y  ");
             else
             {
            	 if((i==y_)&&(j==x_))
            		 System.out.print("X  ");
            	 else
                System.out.print(matrix[i][j]+"  ");    
             }
          }
          System.out.println();
        }
    };
   
    public boolean isFree(int r_,int c_){
        if((r_<0)||(c_<0)||(r_>=h)||(c_>=w))
             return false;
        return(matrix[r_][c_]!=1)?true:false;
        }
    public boolean isFree2(int y_,int x_){
        if((y_<0)||(x_<0)||(y_>=h)||(x_>=w))
             return false;
        return(matrix[y_][x_]!=1)?true:false;
        }
    
    public boolean isFinish(int r_,int c_){
         return (matrix[r_][c_]==8)?true:false;
    }
         public boolean isFinish2(int y_,int x_){
             return (matrix[y_][x_]==8)?true:false;
    }  
}
class Game{
  private Mario2 mario2;
  private Mario mario;
  private Field field;
  
  Game(){
  mario2=new Mario2();
  mario=new Mario();
  field=new Field(11,11);
  }
  
  @SuppressWarnings("resource")
public int getDirection2(){ 
	  int direction11=0;  
	   System.out.print("-->");
	   for(;;)
	   {
	    direction11 = new Scanner(System.in).nextInt();
	   if(direction11==2||direction11==4||direction11==6||direction11==8||direction11==3||direction11==1||direction11==9||direction11==7)
	   {break;}
	   else{System.out.println("Проверьте кнопки управления!");}
	   }
     return direction11;
  }
  
  private int moveMario2(int direction11){
      int temp_y=mario2.y;
      int temp_x=mario2.x;
      
     switch(direction11){
         case 6:temp_x++;break;
         case 4:temp_x--;break;
         case 8:temp_y--;break;
         case 2:temp_y++;break;
         case 1:temp_x--;temp_y++;break;
         case 3:temp_x++;temp_y++;break;
         case 7:temp_x--;temp_y--;break;
         case 9:temp_x++;temp_y--;break;           
     }
     if(field.isFree2(temp_y,temp_x)){ 
      mario2.y=temp_y;
      mario2.x=temp_x;
      return 1;
  }else{
         return 0;
     } 
  }
  
  @SuppressWarnings("resource")
public int getDirection(){ 
	  int direction22=0;
	  
	   System.out.print("-->");
	   for(;;)
	   {
	    direction22 = new Scanner(System.in).nextInt();
	   if(direction22==2||direction22==4||direction22==6||direction22==8||direction22==3||direction22==1||direction22==9||direction22==7)
	   {break;}
	   else{System.out.println("Проверьте кнопки управления!");}
	   }
     return direction22;
  }
  
  private int moveMario(int direction22){
      int temp_r=mario.r;
      int temp_c=mario.c;
      
     switch(direction22){
         case 6:temp_c++;break;
         case 4:temp_c--;break;
         case 8:temp_r--;break;
         case 2:temp_r++;break;
         case 1:temp_c--;temp_r++;break;
         case 3:temp_c++;temp_r++;break;
         case 7:temp_c--;temp_r--;break;
         case 9:temp_c++;temp_r--;break;
     }
     if(field.isFree(temp_r,temp_c)){ 
      mario.r=temp_r;
      
      mario.c=temp_c;
              
      return 1;
  }else{
         return 0;
     } 
  }
 
  @SuppressWarnings("resource")
public void startGame(){
     int direction,direction2;
     
     boolean exit=false;
     System.out.println("///MARIO version 1.0///");
     System.out.println("Начать новую игру(1)");
     System.out.println("Выход(2)");
     int sc = new Scanner(System.in).nextInt();
     switch(sc)
     {
     case 1:{
    	 for (int i=0; i<40; i++)
    		    System.out.println();
    	 System.out.println("Управление");
    	 System.out.print("2-вниз,");
    	 System.out.print("4-влево,");
    	 System.out.print("6-вправо,");
    	 System.out.print("8-вверх,");
    	 System.out.println("Ходы наискосок-1,3,7,9.");
    	 System.out.println("");
    	 System.out.println("Цель-дойти до золота.");
    	 System.out.print("Y-это игрок №1,");
    	 System.out.print("X-это игрок №2,"); 
    	 System.out.print("1-это стена,");
    	 System.out.println("0-проход.");
    	 break;
     }
     case 2:{exit=true;break;}
     }
    if(exit==false)
    {
     mario.r=0;
     mario.c=0;
     mario2.y=0;
     mario2.x=10;
     field.showLocation(mario.r,mario.c,mario2.x,mario2.y);
    }
     while (!field.isFinish(mario.r,mario.c)&&!field.isFinish2(mario2.y,mario2.x))  {
    	 if(exit==true){break;}
      System.out.print("Куда идти 1-му игроку: ");
      direction=getDirection();
      System.out.print("Куда идти 2-му игроку: ");
      direction2=getDirection2();
      if(((moveMario(direction)==1)&&(moveMario2(direction2)==1))||(moveMario(direction)==1)||(moveMario2(direction2)==1)){
    	   for (int i=0; i<40; i++)
   		    System.out.println();
       System.out.println("Оповещение:Путь чист");
      }else{
    	   for (int i=0; i<40; i++)
   		    System.out.println();
          System.out.println("Оповещение:Тут не пройти");
      }
      field.showLocation(mario.r,mario.c,mario2.x,mario2.y);   
      }
     if(exit==false)
     {
    	 if(field.isFinish(mario.r,mario.c))
    	 {
     System.out.println("Поздравляю игрок Y,вы нашли золото!");
     System.out.println("GAME OVER");
     System.out.println("Created by Vladislav&Vasiliy");
    	 }
    	 else 
    	 {
    		  System.out.println("Поздравляю игрок X,вы нашли золото!");
    		     System.out.println("GAME OVER");
    		     System.out.println("Created by Vladislav&Vasiliy");
    	 }
     }
     else{System.out.println("Всего хорошего!");System.out.println("Created by Vladislav&Vasiliy");}
  }     
  }
public class Testgame {
public static void main(String[] args) {
	 Game g=new Game();
	  g.startGame();
}
}
