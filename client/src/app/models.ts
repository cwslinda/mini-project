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
    title: string 
    comment: string 
}