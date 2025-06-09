/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package utilidades;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Sarai
 */
public class DimencionImagen {

   // Método que devuelve la imagen redimensionada como ImageIcon
    public static ImageIcon obtenerImagenRedimensionada(String ruta, int ancho, int alto) {
        ImageIcon iconoOriginal = new ImageIcon(DimencionImagen.class.getResource(ruta));
        Image imagen = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagen);
    }

    // Método que ajusta la imagen y la pone en un JLabel directamente
    public static void ajustarImagenEnLabel(JLabel label, String ruta, int ancho, int alto) {
        ImageIcon icono = obtenerImagenRedimensionada(ruta, ancho, alto);
        label.setIcon(icono);
    }
}
