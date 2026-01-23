import { defaultPerson } from "./defaultPerson";

export const defaultParent = {
    id: null,
    person: { ...defaultPerson },
    parentType: "",
};