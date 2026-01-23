import { defaultContact } from "./defaultContact";

export const defaultPerson = {
    id: null,
    firstName: "",
    middleName: "",
    lastName: "",
    dob: "",
    lifeStatus: "",
    contact: { ...defaultContact },
    createdAt: "",
    updatedAt: "",
    notes: ""
};