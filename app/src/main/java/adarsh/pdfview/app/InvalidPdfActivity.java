package adarsh.pdfview.app;

import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import adarsh.pdfview.library.PDFViewPager;
import adarsh.pdfview.library.adapter.PDFPagerAdapter;
import adarsh.pdfview.library.adapter.PdfErrorHandler;

public class InvalidPdfActivity extends BaseSampleActivity {
    final String invalidPdfPath = "https://live.staticflickr.com/4561/38054606355_26429c884f_b.jpg";

    PDFViewPager pdfViewPager;
    View pdfErrorView;
    PDFPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_invalid_pdf);

        pdfViewPager = findViewById(R.id.pdfViewPager);
        pdfErrorView = findViewById(R.id.pdfErrorView);

        adapter = new PDFPagerAdapter.Builder(this)
                .setErrorHandler(new PdfErrorHandler() {
                    @Override
                    public void onPdfError(Throwable t) {
                        pdfErrorView.setVisibility(VISIBLE);
                    }
                })
                .setPdfPath(invalidPdfPath)
                .create();

        pdfViewPager.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        adapter.close();
    }
}
