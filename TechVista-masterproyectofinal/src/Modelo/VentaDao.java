package Modelo; // Paquete Modelo

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Clase para manejar las operaciones de base de datos relacionadas con ventas
public class VentaDao {

    Connection con; 
    Conexion cn = new Conexion(); 
    PreparedStatement ps; 

    // Método para establecer la conexión a la base de datos
    public int RegistrarVenta(Venta v) {
        String sql = "INSERT INTO ventas (cliente, vendedor, total) VALUES (?,?,?)"; 
        try {
            con = cn.getConnection(); // Establecer la conexión a la base de datos
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

    // Método para registrar una venta en la base de datos
    public int RegistrarDetalle(Detalle DV) {
        String sql = "INSERT INTO detalle (cod_pro, cantidad, precio, id_venta) VALUES (?, ?, ?, ?)";
        try {
            con = cn.getConnection(); // Establecer la conexión a la base de datos
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setString(1, DV.getCod_pro()); 
            ps.setInt(2, DV.getCantidad()); 
            ps.setDouble(3, DV.getPrecio()); 
            ps.setInt(4, DV.getId_venta()); 
            ps.executeUpdate(); 
        } catch (SQLException e) {
            System.out.println(e.toString()); 
        } finally {
            try {
                con.close(); // Cerrar la conexión a la base de datos
            } catch (SQLException e) {
                System.out.println(e.toString()); 
            }
        }
        return 0; 
    }
}
