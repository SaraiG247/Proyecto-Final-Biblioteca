/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import modelo.Libro;

/**
 *
 * @author Sarai
 */
public class GeneradorPDF {

    public static File generarCredencialesPDF(String correo, String contrasena) throws Exception {
        File archivo = new File("credenciales_" + correo + ".pdf");

        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(archivo));
        doc.open();

        // Título
        Font tituloFont = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD, BaseColor.DARK_GRAY);
        Paragraph titulo = new Paragraph("\nGestor de Biblioteca\n" + " Raíces y Letra", tituloFont);
        titulo.setAlignment(Element.ALIGN_CENTER);
        doc.add(titulo);
        doc.add(new Chunk(new LineSeparator()));

        // Subtítulo
        Paragraph subtitulo = new Paragraph("Credenciales de acceso al sistema",
                new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.GRAY));
        subtitulo.setAlignment(Element.ALIGN_CENTER);
        subtitulo.setSpacingBefore(10);
        subtitulo.setSpacingAfter(20);
        doc.add(subtitulo);

        // Tabla con credenciales
        PdfPTable tabla = new PdfPTable(2);
        tabla.setWidthPercentage(100);
        tabla.setWidths(new int[]{1, 2});
        tabla.addCell(getCelda("Correo:", PdfPCell.ALIGN_LEFT));
        tabla.addCell(getCeldaDato(correo));
        tabla.addCell(getCelda("Contraseña:", PdfPCell.ALIGN_LEFT));
        tabla.addCell(getCeldaDato(contrasena));
        doc.add(tabla);

        // Agregar imagen centrada
        URL url = GeneradorPDF.class.getResource("/imagenes/logo.png");
        if (url == null) {
            throw new RuntimeException("No se encontró la imagen en la ruta /imagenes/logo.png");
        }
        Image imagen = Image.getInstance(url);
        imagen.scaleToFit(300f, 300f); // tamaño imagen
        imagen.setAlignment(Element.ALIGN_CENTER);
        imagen.setSpacingBefore(300);  // espacio
        doc.add(imagen);

        doc.close();

        return archivo;
    }

    private static PdfPCell getCelda(String texto, int alineacion) {
        Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        PdfPCell cell = new PdfPCell(new Phrase(texto, font));
        cell.setHorizontalAlignment(alineacion);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setPadding(5);
        return cell;
    }

    private static PdfPCell getCeldaDato(String texto) {
        Font font = new Font(Font.FontFamily.HELVETICA, 12);
        PdfPCell cell = new PdfPCell(new Phrase(texto, font));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setPadding(5);
        return cell;
    }
}
