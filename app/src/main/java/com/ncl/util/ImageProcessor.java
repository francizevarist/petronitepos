package com.ncl.util;

import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import java.io.ByteArrayOutputStream;

public class ImageProcessor {

    /**
     * attris
     */

    /**
     * task: Bitmap
     */
    public static Bitmap encode(String contents, int width, int height) {
        Bitmap bitmap = null;
        int codeWidth = 3 + // start guard
                (7 * 6) + // left bars
                5 + // middle guard
                (7 * 6) + // right bars
                3; // end guard
        codeWidth = Math.max(codeWidth, width);
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
                    BarcodeFormat.CODE_128, codeWidth, height, null);
            //MatrixToImageWriter.writeToStream(bitMatrix, "png",
            //new FileOutputStream(imgPath));
            int aWidth = bitMatrix.getWidth();
            int aHeight = bitMatrix.getHeight();
            int[] pixels = new int[width * height];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (bitMatrix.get(x, y)) {
                        pixels[y * width + x] = 0xff000000;
                    }
                }
            }
            bitmap = Bitmap.createBitmap(width, height,
                    Bitmap.Config.ARGB_8888);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, bos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
