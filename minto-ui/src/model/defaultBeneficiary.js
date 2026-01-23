import { defaultPerson } from "./defaultPerson";

export const defaultBeneficiary = {
    id: null,
    person: { ...defaultPerson },
    percentage: 0,
    relationship: "",
};