
import java.sql.*;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class RegistroEmpleados {
    

static Scanner leer = new Scanner (System.in);



public static void tablaempleados(){
    //paso 1 creamos la conexion a la base de datos
        String url = "jdbc:mysql://localhost:3306/dbcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            //paso 2 creamos el objeto conexion
            Connection conexion = DriverManager.getConnection(url,"root","admin");
            //paso 3 creamos el objeto statement
            Statement sentencia = conexion.createStatement();
            //paso 4 creamos la instruccion
            String sql = "SELECT * FROM dbcomisiones.tb_empleado";
            // paso 5 ejecutamos el query
            ResultSet resultado = sentencia.executeQuery(sql);
            // paso 6. procesar el resultado
            // explicar como se maneja al siguiente registro
            while(resultado.next()){
                System.out.println("\n______________________"); 
                System.out.println("ID: "+resultado.getInt(1)); 
                System.out.println("NIV: "+resultado.getInt(2));
                System.out.println("Nombre: "+resultado.getString(3));
                System.out.println("enero: "+resultado.getInt(4));;
                System.out.println("febrero: "+resultado.getInt(5));
                System.out.println("marzo: "+resultado.getInt(6));
                System.out.println("abril: "+resultado.getInt(7));
                System.out.println("mayo: "+resultado.getInt(8));
                System.out.println("junio: "+resultado.getInt(9));
            }





        } catch (SQLException ex) {
           System.out.println("Hubo clavo:"+ex.getMessage());
        }
}




public static void insertar(){  

System.out.println("Escriba el Niv de empleado"); 
int niv1=leer.nextInt();
System.out.println("Escriba el nombre de empleado"); 
String nombre=leer.next();
System.out.println("Escriba cantidad de enero"); 
int ener=leer.nextInt();
System.out.println("Escriba cantidad de febrero"); 
int febre=leer.nextInt();
System.out.println("Escriba cantidad de marzo"); 
int marz=leer.nextInt();
System.out.println("Escriba cantidad de abril"); 
int abril=leer.nextInt();
System.out.println("Escriba cantidad de mayo"); 
int mayo=leer.nextInt();
System.out.println("Escriba cantidad de junio"); 
int junio=leer.nextInt();

//paso 1 creamos la conexion a la base de datos
        String url = "jdbc:mysql://localhost:3306/dbcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            //paso 2 creamos el objeto conexion
            Connection conexion = DriverManager.getConnection(url,"root","admin");
            //paso 3 creamos el objeto statement
            Statement sentencia = conexion.createStatement();
            //paso 4 creamos la instruccion
       
            String sql = "Insert into tb_empleado (NIV, Nombre, enero, febrero, marzo, abril, mayo, junio ) Values (" +niv1+",'"+nombre+"'," +
                        +ener+","+febre+","+marz+","+abril+","+mayo+","+junio+")";
            // paso 5 ejecutamos el query
            sentencia.executeUpdate(sql);
            // paso 6. procesar el resultado
            // explicar como se maneja al siguiente registro
 
             
            
             System.out.println("Se ha creado");


        } catch (SQLException ex) {
           System.out.println("Hubo clavo:"+ex.getMessage());
        }


}



public static void consult(int Niv){  

  

//paso 1 creamos la conexion a la base de datos
        String url = "jdbc:mysql://localhost:3306/dbcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            //paso 2 creamos el objeto conexion
            Connection conexion = DriverManager.getConnection(url,"root","admin");
            //paso 3 creamos el objeto statement
            Statement sentencia = conexion.createStatement();
            //paso 4 creamos la instruccion
       
            String sql = "SELECT * FROM tb_empleado where NIV = "+Niv;
            // paso 5 ejecutamos el query
            ResultSet resultado = sentencia.executeQuery(sql);
            // paso 6. procesar el resultado
            // explicar como se maneja al siguiente registro
  
                while(resultado.next()){
                System.out.println("\n______________________");
                System.out.println("ID: "+resultado.getInt(1)); 
                System.out.println("NIV: "+resultado.getInt(2));
                System.out.println("Nombre: "+resultado.getString(3));
                System.out.println("enero: "+resultado.getInt(4));;
                System.out.println("febrero: "+resultado.getInt(5));
                System.out.println("marzo: "+resultado.getInt(6));
                System.out.println("abril: "+resultado.getInt(7));
                System.out.println("mayo: "+resultado.getInt(8));
                System.out.println("junio: "+resultado.getInt(9));
                System.out.println("\n______________________");
            }
            
            


        } catch (SQLException ex) {
           System.out.println("Hubo clavo:"+ex.getMessage());
        }


}



public static void sumempleadomes(){  
//paso 1 creamos la conexion a la base de datos
        String url = "jdbc:mysql://localhost:3306/dbcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            //paso 2 creamos el objeto conexion
            Connection conexion = DriverManager.getConnection(url,"root","admin");
            //paso 3 creamos el objeto statement
            Statement sentencia = conexion.createStatement();
            //paso 4 creamos la instruccion
       
            String sql = "select NIV,Nombre,  (enero+febrero+marzo+abril+mayo+junio) from  tb_empleado";
            // paso 5 ejecutamos el query
            ResultSet resultado = sentencia.executeQuery(sql);
            // paso 6. procesar el resultado
            // explicar como se maneja al siguiente registro
  
                while(resultado.next()){
                
                System.out.println("Niv: "+resultado.getString(1));
                System.out.println("Nombre: "+resultado.getString(2));
                System.out.println("suma meses: "+resultado.getInt(3));;
              
            }
            
        } catch (SQLException ex) {
           System.out.println("Hubo clavo:"+ex.getMessage());
        }


}

public static void sumatotalmes(){  
//paso 1 creamos la conexion a la base de datos
        String url = "jdbc:mysql://localhost:3306/dbcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            //paso 2 creamos el objeto conexion
            Connection conexion = DriverManager.getConnection(url,"root","admin");
            //paso 3 creamos el objeto statement
            Statement sentencia = conexion.createStatement();
            //paso 4 creamos la instruccion
       
            String sql = "select  Sum(enero), Sum(febrero), Sum(marzo), Sum(abril), Sum(mayo), Sum(junio) from  tb_empleado";
            // paso 5 ejecutamos el query
            ResultSet resultado = sentencia.executeQuery(sql);
            // paso 6. procesar el resultado
            // explicar como se maneja al siguiente registro
  
                while(resultado.next()){
                
                System.out.println("Suma Enero: "+resultado.getString(1));
                System.out.println("Suma Fegrero: "+resultado.getString(2));
                System.out.println("Suma Marzo: "+resultado.getInt(3));;
                System.out.println("Suma Abril: "+resultado.getInt(4));;
                System.out.println("Suma Mayo: "+resultado.getInt(5));;
                System.out.println("Suma Junio: "+resultado.getInt(6));;
            }
            
        } catch (SQLException ex) {
           System.out.println("Hubo clavo:"+ex.getMessage());
        }


}


public static void Eliminar(int Niv){  

  //paso 1 creamos la conexion a la base de datos
        String url = "jdbc:mysql://localhost:3306/dbcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            //paso 2 creamos el objeto conexion
            Connection conexion = DriverManager.getConnection(url,"root","admin");
            //paso 3 creamos el objeto statement
            Statement sentencia = conexion.createStatement();
            //paso 4 creamos la instruccion
       
            String sql = "delete from tb_empleado where NIV = "+Niv;
            sentencia.executeUpdate(sql);
 System.out.println("Se ha eliminado");

 } catch (SQLException ex) {
           System.out.println("Hubo clavo:"+ex.getMessage());
        }

}


public static void actualizar(int Niv, String name ){  

  //paso 1 creamos la conexion a la base de datos
        String url = "jdbc:mysql://localhost:3306/dbcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            //paso 2 creamos el objeto conexion
            Connection conexion = DriverManager.getConnection(url,"root","admin");
            //paso 3 creamos el objeto statement
            Statement sentencia = conexion.createStatement();
            //paso 4 creamos la instruccion
       
            String sql = "Update tb_empleado set Nombre = "+"'"+name+"'"+" where NIV = "+Niv;
            sentencia.executeUpdate(sql);
 System.out.println("Se ha actualizado");

 } catch (SQLException ex) {
           System.out.println("Hubo clavo:"+ex.getMessage());
        }

}





    public static void main(String[] args) {

int opci;
do{
          System.out.println("\nMENU DE OPCIONES CRUD");
          System.out.println("1. Tabla de Resultados");
          System.out.println("2. Consulta ");
          System.out.println("3. Eliminar");
          System.out.println("4. Actualizar");
          System.out.println("5. insertar");
          System.out.println("6. Salir");
          System.out.println("Ingrese la opcion");

             opci=leer.nextInt();
          

           switch(opci){
            
             case 1: 
                    tablaempleados();
           System.out.println("\nSuma Total por Meses\n"); 
                    sumatotalmes();
                   break;

            case 2:

           System.out.println("BIENVENIDO A LA CONSULTA\n");
           System.out.println("Ingrese NIV a consultar");
           int nv=leer.nextInt();
          consult(nv);
         sumempleadomes();
                   break;

              case 3:
          System.out.println("Ingrese NIV a Eliminar");
          int del=leer.nextInt();
          consult(del);

          System.out.println("Seguro quiere eliminar: \nsi=1 \nno=2");
          int eli=leer.nextInt();         
          if(eli==1){
          Eliminar(del);
          }
          else{
          if(eli==2){
           System.out.println("No has eliminado");
           }
           }

                   break;


             case 4:
          System.out.println("Ingrese NIV a Actualizar");
          int nom=leer.nextInt();

          System.out.println("Empleado a actualizar");
          consult(nom);
          System.out.println("Ingrese nuevo nombre");
          String nme=leer.next();
      actualizar(nom,nme);

             break;

             case 5:
                  insertar();

             break;
             case 6:
            System.out.println("salir");
             break;
               default:
               System.out.println("DATO INVALIDO");
         
               }

             }while(opci!=6);

       
    }



}
