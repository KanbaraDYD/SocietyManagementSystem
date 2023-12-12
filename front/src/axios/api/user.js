import { get,post } from "../axios"

export function login(params)
{
    return post("/user/login",params)
}

export function sign(params)
{
    return post("/user/sign",params)
}

export function getUserById(params)
{
    return get("/user/getUserById",params)
}