package learn.english.cofriends.reades.service.book;

import android.content.Context;

import learn.english.cofriends.reades.entity.Book;
import learn.english.cofriends.reades.service.DownloadService;

public class BookDownloadService extends DownloadService {

    public static void start(Context context, Loadable loadable) {
        DownloadService.start(context, loadable, BookDownloadService.class);
    }

    @Override
    public void onLoaded(Loadable loadable) {
        if (loadable instanceof Book) {
            Book book = (Book) loadable;
            // mention that it was taken from library
            book.setSourceType(Book.SourceType.LIBRARY);
            SavedBooksService.actUpon(this, book, SavedBooksService.SAVE);
        }
    }
}
