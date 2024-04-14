public boolean ActualizarStock(int cant, String cod) {
    // Actualiza el stock de un producto en la base de datos y retorna si la operación fue exitosa.
    String sql = "UPDATE productos SET stock = ? WHERE codigo = ?";
    try (Connection con = cn.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, cant);
        ps.setString(2, cod);
        ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println(e.toString());
        return false;
    }
}
public boolean ActualizarStock(int cant, String cod) {
    // Actualiza el stock de un producto en la base de datos y retorna si la operación fue exitosa.
    String sql = "UPDATE productos SET stock = ? WHERE codigo = ?";
    try (Connection con = cn.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, cant);
        ps.setString(2, cod);
        ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println(e.toString());
        return false;
    }
}



private void ActualizarStock() {
    // Actualiza el stock de productos en la base de datos según las ventas realizadas.
    for (int i = 0; i < TableVenta.getRowCount(); i++) {
        String cod = TableVenta.getValueAt(i, 0).toString();
        int cant = Integer.parseInt(TableVenta.getValueAt(i, 2).toString());
        Producto pro = proDao.BuscarPro(cod);
        int stockActual = pro.getStock() - cant;
        Vdao.ActualizarStock(stockActual, cod);
    }
}






private void LimpiarTableVenta() {
    // Este método limpia los datos de la tabla TableVenta.
    DefaultTableModel tmp = (DefaultTableModel) TableVenta.getModel();
    int fila = TableVenta.getRowCount();
    for (int i = 0; i < fila; i++) {
        tmp.removeRow(0);
    }
}



private void LimpiarClienteventa() {
    // Este método limpia los campos de entrada de información del cliente en la venta.
    txtRucVenta.setText("");
    txtNombreClienteventa.setText("");
    txtTelefonoCV.setText("");
    txtDireccionCV.setText("");
}



