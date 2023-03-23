export interface Person {
    person_id: number;
    identification_type_Id: number;
    identification_number: string;
    first_name: string;
    middle_name?: string;
    last_name: string;
    second_last_name?: string;
    person_type_id: number;
    date_of_birth: Date;
    email: string;
    creation_date: Date;
    creation_user_id: number;
    modification_date?: Date;
}