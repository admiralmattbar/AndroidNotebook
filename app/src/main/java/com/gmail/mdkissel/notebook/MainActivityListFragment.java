package com.gmail.mdkissel.notebook;


import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityListFragment extends ListFragment {
    private ArrayList<Note> notes;
    private NoteAdapter noteAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        notes = new ArrayList<Note>();
        notes.add(new Note("This is a new note title", "This is the body of our note. It kicks ass while sodomizing your mom on a jetskii", Note.Category.PERSONAL));
        notes.add(new Note("Hi", "What you fuck?!", Note.Category.FINANCE));
        notes.add(new Note("Ho", "That's what you are", Note.Category.QUOTE));
        notes.add(new Note("Buttmunch", "You love it, don't you", Note.Category.TECHNICAL));
        notes.add(new Note("I'm UnPC", "Hitler did nothing wrong", Note.Category.FINANCE));
        notes.add(new Note("Trump", "He is mein new Furher", Note.Category.PERSONAL));
        notes.add(new Note("Clinton", "She's a lizard alien, I read it on the Internet!", Note.Category.FINANCE));
        notes.add(new Note("Fuck", "It's my favorite word", Note.Category.FINANCE));
        notes.add(new Note("Shapoopi", "This is the girl that's hard to get. Go ahead, give it a try. You can't, can you? See? You didn't listen to me.", Note.Category.QUOTE));
        notes.add(new Note("Marion", "She's this library that I totally heard puts out!", Note.Category.QUOTE));

        noteAdapter = new NoteAdapter(getActivity(), notes);

        setListAdapter(noteAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        launchNoteDetailActivity(position);

    }

    private void launchNoteDetailActivity(int position) {

        // Grab the note information associated wtih whatever note item we clicked on.
        Note note = (Note) getListAdapter().getItem(position);

        // Create a new intent that launches our note detail activity
        Intent intent = new Intent(getActivity(), NoteDetailActivity.class);

        // Pass along the information of the note we clicked on to our noteDetailActivity
        intent.putExtra(MainActivity.NOTE_TITLE_EXTRA, note.getTitle());
        intent.putExtra(MainActivity.NOTE_MESSAGE_EXTRA, note.getMessage());
        intent.putExtra(MainActivity.NOTE_CATEGORY_EXTRA, note.getCategory());
        intent.putExtra(MainActivity.NOTE_ID_EXTRA, note.getId());

        // Start activity with the intent
        startActivity(intent);
    }

}
