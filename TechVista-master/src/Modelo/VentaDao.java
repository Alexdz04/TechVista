package Modelo; // Paquete Modelo

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Clase para manejar las operaciones de base de datos relacionadas con ventas
public class VentaDao {

    Connection con; 
    Conexion cn = new Conexion(); 
    PreparedStatement ps; 

    // Método para registrar una venta en la base de datos
    public int RegistrarVenta(Venta v) {
        String sql = "INSERT INTO ventas (cliente, vendedor, total) VALUES (?,?,?)"; 
        try {
            con = cn.getConnection(); 
            ps = con.prepareStatement(sql); 
            ps.setString(1, v.getCliente()); 
            ps.setString(2, v.getVendedor()); 
            ps.setDouble(3, v.getTotal()); 
            ps.executeUpdate(); 
        } catch (SQLException e) {
            System.out.println(e.toString()); 
        }
        return 0; 
    }
}
