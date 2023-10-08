INSERT INTO book (id, isbn, title, genre, description, author, status)
VALUES
    (1, '978-0345391803', 'Dune', 'Science Fiction', 'A epic science fiction novel', 'Frank Herbert', 'AVAILABLE'),
    (2, '978-0451457998', 'Neuromancer', 'Science Fiction', 'A cyberpunk classic', 'William Gibson', 'AVAILABLE'),
    (3, '978-0141439747', 'Pride and Prejudice', 'Romance', 'A classic romance novel', 'Jane Austen', 'AVAILABLE'),
    (4, '978-0061120084', 'To Kill a Mockingbird', 'Fiction', 'A novel about racism and injustice', 'Harper Lee', 'AVAILABLE'),
    (5, '978-1400032716', 'The Great Gatsby', 'Fiction', 'A story of wealth and decadence', 'F. Scott Fitzgerald', 'AVAILABLE'),
    (6, '978-0451526342', '1984', 'Science Fiction', 'A dystopian classic', 'George Orwell', 'AVAILABLE'),
    (7, '978-0553106633', 'A Song of Ice and Fire', 'Fantasy', 'A fantasy series', 'George R. R. Martin', 'AVAILABLE'),
    (8, '978-0765326355', 'The Name of the Wind', 'Fantasy', 'The first book in a fantasy series', 'Patrick Rothfuss', 'AVAILABLE'),
    (9, '978-0141182801', 'The Catcher in the Rye', 'Fiction', 'A coming-of-age novel', 'J.D. Salinger', 'AVAILABLE'),
    (10, '978-0060850524', 'The Hobbit', 'Fantasy', 'A fantasy adventure novel', 'J.R.R. Tolkien', 'AVAILABLE');

insert into users (username, password)
values ('admin', '$2a$12$AJexltVmFLsXIu6FhxXHdeniQ78hgojaTiZPKjtjJDbnG7IqXJSTm');