export interface Observation{
    observation_id: number;
    employee_id?: number;
    student_id?: number;
    dependency_id: number;
    reason_id: number;
    observation: string;
    recomendation: string;
    creation_date: Date;
    modification_date?: Date ;
    relationship_id?: number;
    identificationtype_id?: number;
    identification_number_visitor?: string;
    visitor_name?: string;
    evidence?: string;
    creation_user_id: number;
    modification_user_id?: number;
}