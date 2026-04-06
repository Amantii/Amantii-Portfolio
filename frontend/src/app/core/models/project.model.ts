export interface ProjectModel {
    id: number;
    title: string;
    description: string;
    githubUrl: string;
    liveUrl: string;
    tags: string[];
    featured: boolean;
    sortOrder: number;
}