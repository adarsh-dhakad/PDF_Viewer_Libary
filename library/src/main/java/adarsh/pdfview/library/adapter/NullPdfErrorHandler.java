package adarsh.pdfview.library.adapter;

class NullPdfErrorHandler implements PdfErrorHandler {
    @Override
    public void onPdfError(Throwable t) {
        /* Empty */
    }
}