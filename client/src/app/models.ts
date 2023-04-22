export interface User {
    username: string
    password: string
    email: string
    id: string
}


export interface Book {
    id: string
    title: string
    description: string
    authors: []
    publishedDate: string
    urlLink: string
    imageUrl: string
    previewLink: string

}

export interface Comment {
    bookId: string
    userId: string
    commentTitle: string 
    comment: string 
}

export interface CommentResult {
    bookId: string
    comment: string
    commentDate: string
    commentId: string
    commentTitle: string
    userId: string
    username: string
}