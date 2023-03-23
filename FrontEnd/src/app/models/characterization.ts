export interface Characterization{
    characterization_id: number;
    characteristic_id: number;
    student_id: number;
    status: boolean;
    creation_user_id: number;
    creation_date: Date;
    modification_date?: Date;
    modification_user_id: number;
}