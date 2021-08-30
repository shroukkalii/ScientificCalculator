package ScCalc;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.lang.Math;
import java.math.BigDecimal;
import java.math.BigInteger;


public class ScCalc extends Application {
    
   public static BigInteger factorial(int number) {
       BigInteger factorial = BigInteger.ONE;
       for (int i = number; i > 0; i--) 
       { 
           factorial = factorial.multiply(BigInteger.valueOf(i));
       } 
       return factorial; 
   }

    int base=10;
    @Override
    public void start(Stage primaryStage) {
        
        TextField txt_x = new TextField();
        TextField txt_y = new TextField();
        
        Label lbl_result = new Label();
        
        Label lbl_base = new Label("BASE:");
        Label lbl_first = new Label("Enter the first number :");
        Label lbl_second = new Label("Enter the second number :");
        Label lbl_eq = new Label("Equals:");
        
        Button btn_clr = new Button("C");
        
        Button btn_add = new Button("+");
        Button btn_sub = new Button("-");
        Button btn_mup = new Button("x");
        Button btn_div = new Button("/");
        Button btn_intdiv = new Button("//");
        Button btn_mod = new Button("%");
        Button btn_pow = new Button("^");
        Button btn_log = new Button("Log");
        Button btn_ln = new Button("Ln");
        Button btn_fact = new Button("!"); 
        Button btn_abs = new Button("abs");
        Button btn_sqrt = new Button("sqrt");
        Button btn_cbrt = new Button("cbrt");
        Button btn_sin = new Button("sin");
        Button btn_cos = new Button("cos");
        Button btn_tan = new Button("tan");
        
        
        ComboBox comb = new ComboBox();
        comb.getItems().addAll("DEC","HEX","OCT","BIN");
        comb.setValue("DEC"); //default value
        comb.setMinWidth(150);
        comb.valueProperty().addListener(new ChangeListener<String>(){
        @Override
                public void changed(ObservableValue ov, String x,String y){
                        if(y.equals("DEC"))
                            base=10;
                        else if(y.equals("HEX"))
                            base=16;
                        else if(y.equals("OCT"))
                            base=8;
                        else
                            base=2;
                }
        });
              
               
        HBox hbox = new HBox();
        hbox.getChildren().addAll(lbl_base,comb);
        
        GridPane grid= new GridPane();
        grid.setVgap(15); //vertical gap
        grid.setHgap(10);
        grid.add(lbl_base,0,0);
        grid.add(hbox, 1, 0);
        grid.add(txt_x,0,3);
        grid.add(lbl_first,0,2);
        grid.add(lbl_second,0,4);
        grid.add(txt_y,0,5);
        grid.add(btn_add,1,2); 
        grid.add(btn_sub,2,2);
        grid.add(btn_mup,1,3);
        grid.add(btn_div,1,4);
        grid.add(btn_intdiv,2,4);
        grid.add(btn_mod,2,5);
        grid.add(btn_pow,2,3);
        grid.add(btn_log,2,6);
        grid.add(btn_fact,1,5);
        grid.add(lbl_result,0,7);
        grid.add(lbl_eq,0,6);
        grid.add(btn_clr,0,1);
        grid.add(btn_abs,2,8);
        grid.add(btn_sqrt,1,9);
        grid.add(btn_cbrt,2,9);
        grid.add(btn_sin,1,7);
        grid.add(btn_cos,2,7);
        grid.add(btn_tan,1,8);
        grid.add(btn_ln,1,6);
        
        btn_clr.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                    txt_x.setText("");
                    txt_y.setText("");
                    lbl_result.setText("");
                }
            
        });
       
        btn_add.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                try{
                    if(base == 10)
                    { 
                        BigDecimal num1 = new BigDecimal(txt_x.getText());
                        BigDecimal num2 = new BigDecimal(txt_y.getText());
                        BigDecimal result = num1.add(num2);
                        lbl_result.setText(result.toString());
                    }
                    else 
                    { 
                        
                        BigInteger num1 = new BigInteger(txt_x.getText() , base);
                        BigInteger num2 = new BigInteger(txt_y.getText() , base);
                        BigInteger result = num1.add(num2);
                                
                        lbl_result.setText(result.toString());
                    }

                   }
                catch(NumberFormatException nfe){
                    lbl_result.setText("INVALID");
                      }
            }
        });
        
        btn_sub.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                try{
                    if(base == 10){
                        
                        BigDecimal num1 = new BigDecimal(txt_x.getText());
                        BigDecimal num2 = new BigDecimal(txt_y.getText());
                        BigDecimal result = num1.subtract(num2);
                        lbl_result.setText(result.toString());
                    }
                    else 
                    { 
                        
                        BigInteger num1 = new BigInteger(txt_x.getText() , base);
                        BigInteger num2 = new BigInteger(txt_y.getText() , base);
                        BigInteger result = num1.subtract(num2);
                        
                        lbl_result.setText(result.toString());
                    }

                   }
                catch(NumberFormatException nfe){
                    lbl_result.setText("INVALID");
                }
            }
        });
        
        btn_mup.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                try{
                    if (base==10)
                    { 
                        BigDecimal num1 = new BigDecimal(txt_x.getText());
                        BigDecimal num2 = new BigDecimal(txt_y.getText());
                        BigDecimal result = num1.multiply(num2);
                        lbl_result.setText(result.toString());
                    }
                    else 
                    {
                        
                        BigInteger num1 = new BigInteger(txt_x.getText() , base);
                        BigInteger num2 = new BigInteger(txt_y.getText() , base);
                        BigInteger result = num1.multiply(num2);
                        lbl_result.setText(result.toString());
                    }

                   }
                catch(NumberFormatException nfe){
                    lbl_result.setText("INVALID");
                }
            }
        });
        
        btn_div.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                try{
                    if (base==10)
                    {   BigDecimal num1 = new BigDecimal(txt_x.getText());
                        BigDecimal num2 = new BigDecimal(txt_y.getText());
                        BigDecimal result = num1.divide(num2);
                        lbl_result.setText(result.toString());
                    }
                    else 
                    { 
                        
                        BigInteger num1 = new BigInteger(txt_x.getText() , base);
                        BigInteger num2 = new BigInteger(txt_y.getText() , base);
                        BigInteger result = num1.divide(num2);
                        
                        lbl_result.setText(result.toString());
                    }

                   }
                catch(ArithmeticException athe){
                    lbl_result.setText("You shouldn't divide a number by zero");
                     }
                catch(NumberFormatException nfe){
                    lbl_result.setText("INVALID");
                }
                
            }});
   
        btn_intdiv.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                try{
                        BigInteger num1 = new BigInteger(txt_x.getText() , base);
                        BigInteger num2 = new BigInteger(txt_y.getText() , base);
                        BigInteger result = num1.divide(num2);
                        lbl_result.setText(result.toString());
                    }

                   
                catch(ArithmeticException athe){
                    lbl_result.setText("You shouldn't divide a number by zero");
            }
                catch(NumberFormatException nfe){
                    lbl_result.setText("INVALID");
                }
            }
         });
        
        btn_mod.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                try{
                    if(base==10)
                    {   BigDecimal num1 = new BigDecimal(txt_x.getText());
                        BigDecimal num2 = new BigDecimal(txt_y.getText());
                        BigDecimal result = num1.remainder(num2);
                        lbl_result.setText(result.toString());
                    }
                    else 
                    {
                        
                        BigInteger num1 = new BigInteger(txt_x.getText() , base);
                        BigInteger num2 = new BigInteger(txt_y.getText() , base);
                        BigInteger result = num1.mod(num2);
                        lbl_result.setText(result.toString());
                    }

                   }
                catch(NumberFormatException nfe){
                    lbl_result.setText("INVALID");
                }
            }
        });
        
        btn_pow.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                try{
                    if(base==10)
                    {   BigDecimal num1= new BigDecimal(txt_x.getText());
                        int num2 =Integer.parseInt(txt_y.getText(),base);
                        BigDecimal result = num1.pow(num2);
                        
                        lbl_result.setText(result.toString());
                    }
                    else
                    {   BigInteger num1 = new BigInteger(txt_x.getText() , base);
                        int num2 =Integer.parseInt(txt_y.getText(),base);
                        BigInteger result = num1.pow(num2);
                        
                        lbl_result.setText(result.toString());
                    }

                   }
                catch(NumberFormatException nfe){
                    lbl_result.setText("INVALID");
                }
            }
        });
        
        btn_log.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                try{
                     if(base==10)
                     {
                    double x= Double.parseDouble(txt_x.getText());
                    double y= Double.parseDouble(txt_y.getText());
                    double result = Math.log(x)/Math.log(y);
                    lbl_result.setText(Double.toString((result)));
                     }
                     else
                     { //3ashan ab3atlo elbase anhe w double mbtkhodsh base wna lazem double
                     BigInteger num1 = new BigInteger(txt_x.getText() , base);
                     BigInteger num2 = new BigInteger(txt_y.getText() , base);
                     double x= Double.parseDouble(num1.toString());
                     double y= Double.parseDouble(num2.toString());
                     double result = Math.log(x)/Math.log(y);
                     lbl_result.setText(Double.toString((result)));
                     }
                }
                catch(NumberFormatException nfe){
                    lbl_result.setText("INVALID");
                }
            }
        });
        
        
         btn_ln.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                try{
                     if(base==10)
                     {
                    double x= Double.parseDouble(txt_x.getText());
                    double result = Math.log(x);
                    lbl_result.setText(Double.toString((result)));
                     }
                     else
                     { //3ashan ab3atlo elbase anhe w double mbtkhodsh base wna lazem double
                     BigInteger num1 = new BigInteger(txt_x.getText() , base);
                    
                     double x= Double.parseDouble(num1.toString());
                    
                     double result = Math.log(x);
                     lbl_result.setText(Double.toString((result)));
                     }
                }
                catch(NumberFormatException nfe){
                    lbl_result.setText("INVALID");
                }
            }
        });
        btn_fact.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                try{
                    int x= Integer.parseInt(txt_x.getText() , base);
                    BigInteger result = factorial(x);
                    lbl_result.setText(result.toString());
                }
                catch(NumberFormatException nfe){
                    lbl_result.setText("INVALID");
                }
            }
        }); 
    
        btn_tan.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                try{
                        Double degree = new Double(txt_x.getText());
                        Double result = Math.tan(Math.toRadians(degree));
                        lbl_result.setText(result.toString());
                    }
                catch(NumberFormatException nfe){
                        lbl_result.setText("INVALID");
                }
            }
         });
       
        btn_cos.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                try{
                         Double degree = new Double(txt_x.getText());
                        Double result = Math.cos(Math.toRadians(degree));
                        
                        lbl_result.setText(result.toString());
                    }

                   
                catch(NumberFormatException nfe){
                    lbl_result.setText("INVALID");
                }
            }
         });
        
        btn_sin.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                try{
                         Double degree = new Double(txt_x.getText());
                        
                        Double result = Math.sin(Math.toRadians(degree));
                        
                        lbl_result.setText(result.toString());
                    }

                   
                catch(NumberFormatException nfe){
                    lbl_result.setText("INVALID");
                }
            }
         });
        
        btn_sqrt.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                try{
                         Double num1 = new Double(txt_x.getText());
                       
                        Double result = Math.sqrt(num1);
                        
                        lbl_result.setText(result.toString());
                    }
                /*if negative, Math.sqrt does not throw an ArithmeticException
                 It throws NaN */
              
                catch(NumberFormatException nfe){
                    lbl_result.setText("INVALID");
                }
            }
         });
        
        btn_cbrt.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                try{
                         Double num1 = new Double(txt_x.getText());
                       
                        Double result = Math.cbrt(num1);
                        
                        lbl_result.setText(result.toString());
                    }

                   
                catch(NumberFormatException nfe){
                    lbl_result.setText("INVALID");
                }
            }
         });
        
        btn_abs.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                try{
                        Double num1 = new Double(txt_x.getText());
                       
                        Double result = Math.abs(num1);
                        
                        lbl_result.setText(result.toString());
                    }

                   
                catch(NumberFormatException nfe){
                    lbl_result.setText("INVALID");
                }
            }
         });
        
        
        Scene scene = new Scene (grid,400,400);
        
        primaryStage.setTitle("Scientific Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        
    public static void main(String[] args) {
        launch(args);
    }
    
}
