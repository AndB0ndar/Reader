package com.example.coursearchmos.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursearchmos.BookActivity;
import com.example.coursearchmos.R;
import com.example.coursearchmos.model.Book;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
	Context context;
	List<Book> books;

	public BookAdapter(Context context, List<Book> books) {
		this.context = context;
		this.books = books;
	}

	@NonNull
	@Override
	public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View bookItem = LayoutInflater.from(context).inflate(R.layout.book_item, parent, false);
		return new BookViewHolder(bookItem);
	}

	@Override
	public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
		holder.bookTitle.setText(books.get(position).getTitle());
		holder.bookAuthor.setText(books.get(position).getAuthor());

		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, BookActivity.class);
				intent.putExtra(Book.class.getCanonicalName(), books.get(holder.getAdapterPosition()));
				context.startActivity(intent);
			}
		});
	}

	@Override
	public int getItemCount() {
		return books.size();
	}

	public static final class BookViewHolder extends RecyclerView.ViewHolder {

		ImageView bookImage;
		TextView bookTitle, bookAuthor;

		public BookViewHolder(@NonNull View itemView) {
			super(itemView);

			bookImage = itemView.findViewById(R.id.image);
			bookTitle = itemView.findViewById(R.id.title);
			bookAuthor = itemView.findViewById(R.id.author);
		}
	}
}
