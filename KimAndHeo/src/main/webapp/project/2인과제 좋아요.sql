DROP TABLE likes;
------------------------------------------------
CREATE TABLE likes (
   id varchar2(50),
    who_likes_it varchar2(50),
    is_liked varchar2(50),
   CONSTRAINT likes_fk FOREIGN KEY (id)
    REFERENCES product (id)
);
----------------------------------------------
SELECT * FROM likes;